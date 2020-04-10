package com.ming.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @ResponseBody()
    @RequestMapping("/sayHello")
    public String hello() {
        return "Hello World";
    }
}
