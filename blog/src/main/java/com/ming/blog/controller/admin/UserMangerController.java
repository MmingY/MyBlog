package com.ming.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMangerController {
    @PostMapping("/login")
    public String postLogin(String name, String password) {
        System.out.println("name:" + name + " ,password：" + password);
        return "success";
    }

    @GetMapping("/login")
    public String postLogin2(String name, String password) {
        System.out.println("name:" + name + " ,password：" + password);
        return "success";
    }
}
