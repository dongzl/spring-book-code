package com.spring.boot.step.security;

import com.spring.boot.step.exception.BusinessException;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.model.AyUserRoleRel;
import com.spring.boot.step.service.IAyRoleService;
import com.spring.boot.step.service.IAyUserRoleRelService;
import com.spring.boot.step.service.IAyUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:48
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Resource
    private IAyUserService ayUserService;

    @Resource
    private IAyUserRoleRelService ayUserRoleRelService;

    @Resource
    private IAyRoleService ayRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AyUser ayUser = ayUserService.findByUserName(name);
        if (ayUser == null) {
            throw new BusinessException("用户不存在");
        }
        List<AyUserRoleRel> ayRoleList = ayUserRoleRelService.findByUserId(ayUser.getId());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if (ayRoleList != null && ayRoleList.size() > 0) {
            for (AyUserRoleRel rel : ayRoleList) {
                String roleName = ayRoleService.find(rel.getRoleId()).getName();
                authorityList.add(new SimpleGrantedAuthority(roleName));
            }
        }
        return new User(ayUser.getName(), ayUser.getPassword(), authorityList);
    }
}
