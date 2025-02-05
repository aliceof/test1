package com.alice.test1.test1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.ScreenSleepEvent;

@RestController
public class AdminController {
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,@RequestParam String password){
        try{
            userServicce.registerUser(username,password);

        return ResponseEntity.ok("ユーザー登録成功");
    }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password){
        boolean success=userService.login(username,password);
        if (success){
            return ResponseEntity.ok("ログイン成功");
        }else {
            return ResponseEntity.badRequest().body("ログイン失敗");
        }
    }
}
