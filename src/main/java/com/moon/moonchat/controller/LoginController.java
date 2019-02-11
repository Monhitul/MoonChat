package com.moon.moonchat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于接收登录请求
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public String forLogin(){
        return "pages/tologin";
    }
}
