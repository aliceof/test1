package com.alice.test1.test1.controller;
import com.alice.test1.test1.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.out;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService RegisterService;

    @PostMapping("/register")
    public void register(@RequestParam String username, @RequestParam String rawpassword, Model model) {
        model.addAttribute("message", "ユーザー登録");
        try {
            RegisterService.registerUser(username, rawpassword);
            out.println("登録成功");
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        }
    }}



