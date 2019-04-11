package com.spring.boot.step.controller;

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

    @RequestMapping("/test")
    public String test(Model model) {
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users", ayUser);
        return "ayUser";
    }
}
