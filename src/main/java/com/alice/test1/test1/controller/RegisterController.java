package com.alice.test1.test1.controller;
import com.alice.test1.test1.Service.RegisterService;
import com.alice.test1.test1.Service.impl.RegisterServiceImpl;
import com.alice.test1.test1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.err;
import static java.lang.System.out;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService RegisterService;

    @GetMapping
    private String showRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username, @RequestParam String rawpassword, Model model) {
        model.addAttribute("message", "ユーザー登録");
        try {
            RegisterService.registerUser(username, rawpassword);
            System.out.println("登録成功");
            return "redirect:/index";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error",e.getMessage());
            return "register";
        }
    }}



