package com.alice.test1.test1.controller;
import com.alice.test1.test1.Service.RegisterService;
import com.alice.test1.test1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService RegisterService;

    @GetMapping("/register")
    private String showRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
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



