package com.alice.test1.test1.controller;


import com.alice.test1.test1.Service.impl.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController{

    private LoginServiceImpl loginService=new LoginServiceImpl();

    @GetMapping("/")
    public String index() {
        return "index"; // 直接返回 index.html
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String rawpassword, Model model){
        model.addAttribute("message", "欢迎使用 Spring Boot + Thymeleaf!");
        boolean isAuthenticated=loginService.login(username,rawpassword);
        if (isAuthenticated){
            return("Alicedashboard");
        }else {
            model.addAttribute("error", "用户名或密码错误");
            return("index");
        }
    }
}