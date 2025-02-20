package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.LoginService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginServiceImpl implements LoginService {

    private UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    @RequestMapping("/login")
    public boolean login(String username, String rawPassword){
        User user = userMapper.findUserByName(username);
        if (user==null){
            return false;
        }
        return passwordEncoder.matches(rawPassword,user.getPassword());
    }
}
