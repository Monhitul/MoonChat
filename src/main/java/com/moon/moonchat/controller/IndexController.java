package com.moon.moonchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  用于接收聊天主页的请求
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/goto")
    public String gotoIndex(){
        return "user";
    }

    @GetMapping("/temp")
    public String Test(){
        return "temp";
    }

    @GetMapping("/main")
    public String toRoom(){
        return "main";
    }
}
