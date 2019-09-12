package com.spring.boot.self;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-12 10:15
 */
@Controller
@EnableAutoConfiguration
public class HelloController {

    @GetMapping("/hello1")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }
}
