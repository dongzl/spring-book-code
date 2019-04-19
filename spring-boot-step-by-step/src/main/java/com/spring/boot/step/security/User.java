package com.spring.boot.step.security;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-19 14:57
 */
public class User implements UserDetails, CredentialsContainer {


    private static final long serialVersionUID = -5915775388709150321L;

    private String password;

//    private final String username;
//
//    public User(String password, String username, Collection<? extends GrantedAuthority> authorities) {
//        this(username, password, true, true, true, true, authorities);
//    }


    @Override
    public void eraseCredentials() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
