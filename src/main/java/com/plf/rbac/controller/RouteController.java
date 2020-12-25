package com.plf.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端路由
 * @Author Panlf
 * @since 2020-07-23
 */
@RequestMapping
@Controller
public class RouteController {

    @GetMapping("login")
    public String toLogin(){
        return "login";
    }

    @GetMapping("index")
    public String toIndex(){
        return "index";
    }

    @GetMapping("user")
    public String toUser(){
        return "user";
    }

    @GetMapping("menu")
    public String toMenu(){
        return "menu";
    }
}
