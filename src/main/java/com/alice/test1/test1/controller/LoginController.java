package com.alice.test1.test1.controller;

import com.alice.test1.test1.Service.impl.LoginServiceImpl;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController  {

private LoginServiceImpl loginService=new LoginServiceImpl();

@RequestMapping("/login")
public String login(@RequestParam String username, @RequestParam String rawpassword){

    boolean isAuthenticated=loginService.login(username,rawpassword);
    if (isAuthenticated){
        return("Alicedashboard");
    }else {
        return("AliceLogin");
    }
}
}
