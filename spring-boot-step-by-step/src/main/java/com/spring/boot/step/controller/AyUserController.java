package com.spring.boot.step.controller;

import com.spring.boot.step.exception.BusinessException;
import com.spring.boot.step.model.AyUser;
import com.spring.boot.step.service.IAyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-04-11 10:24
 */
@Controller
@RequestMapping("/ayUser")
public class AyUserController {

    @Autowired
    private IAyUserService ayUserService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users", ayUser);
        throw new BusinessException("业务异常");
    }

    @RequestMapping("/test")
    public String test(Model model) {
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users", ayUser);
        return "success";
    }

    @RequestMapping("/findByNameAndPasswordRetry")
    public String findByNameAndPasswordRetry(Model model) {
        AyUser ayUser = ayUserService.findByNameAndPasswordRetry("阿毅", "123456");
        model.addAttribute("users", ayUser);
        return "success";
    }
}
