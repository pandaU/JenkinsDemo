package com.example.cicd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/")
    public Object  login(){
        return "hello  登录成功咯  jenkis";
    }
}
