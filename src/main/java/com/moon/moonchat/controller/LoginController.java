package com.moon.moonchat.controller;

import com.moon.moonchat.entity.User;
import com.moon.moonchat.entity.UserLogin;
import com.moon.moonchat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于接收登录和注册请求
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

//    接收用户登录请求
    @PostMapping(value="/check")
    public Map forLogin(@RequestBody User user){
        System.out.println("+++++++++++收到登录请求");
        Map<String, Object> resMap = new HashMap<String, Object>();

        User u = loginService.checkLogin(user);
        if (u!=null) {
            resMap.put("success", "1");     //1为成功
            resMap.put("info", u);
        }
        else
            resMap.put("success", "0");     //0为失败

        return resMap;
    }

//    接收用户注册请求
    @PostMapping(value="/register")
    public Map forRegister(@RequestBody User user){
        System.out.println("*****收到注册请求");
        Map<String, Object> resMap = new HashMap<String, Object>();
        System.out.println(user);
        boolean b = loginService.addUser(user);
        if(b)
            resMap.put("success", "1");
        else
            resMap.put("success", "0");
        return resMap;
    }

    //测试
    @GetMapping("/test")
    public Map getSome(){
        System.out.println("*****收到测试请求");
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("success", "1");
        return resMap;
    }
}