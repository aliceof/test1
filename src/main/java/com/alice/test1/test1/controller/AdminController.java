package com.alice.test1.test1.controller;
import com.alice.test1.test1.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.util.JpaMetamodel;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.ScreenSleepEvent;

@RestController
public class AdminController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam int id, @RequestParam String rawpassword, Model model){
        model.addAttribute("message","ユーザー登録");
        try{
            userService.registerUser(id,rawpassword);

        return ResponseEntity.ok("ユーザー登録成功");
    }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam int id,@RequestParam String rawpassword){
        boolean success=userService.login(id,rawpassword);
        if (success){
            return ResponseEntity.ok("ログイン成功");
        }else {
            return ResponseEntity.badRequest().body("ログイン失敗");
        }
    }
}
