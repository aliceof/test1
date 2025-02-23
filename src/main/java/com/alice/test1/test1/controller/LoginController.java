package com.alice.test1.test1.controller;


import com.alice.test1.test1.Service.impl.LoginServiceImpl;
import com.alice.test1.test1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController{
    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user",new User());
        return "index"; // 直接返回 index.html
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String rawpassword, Model model){
        boolean isAuthenticated=loginService.login(username,rawpassword);
        if (isAuthenticated){
            return("foodnote");
        }else {
            model.addAttribute("error", "用户名或密码错误");
            return("index");
        }
    }
}