package com.example.cicd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/")
    public Object  login(){
        return "hello Jenkins  部署成功";
    }
}
