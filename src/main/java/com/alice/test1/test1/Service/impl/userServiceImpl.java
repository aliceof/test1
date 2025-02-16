package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.userService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class userServiceImpl implements userService{

    @Autowired
    private  UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


    @Override
    public User registerUser(int id,String rawpassword){
        if (userMapper.findById(id)!=null){
            throw new IllegalArgumentException("このユーザー名は既に使われている");
        }
        User user=new User();
        user.setId(id);
        user.setPassword((passwordEncoder.encode(rawpassword)));
        return userMapper.saveUser(user);
    }
    @Override
    @RequestMapping("/login")
    public boolean login(int id, String rawPassword){
        User user = userMapper.findById(id);
        if (user==null){
            return false;
        }
        return passwordEncoder.matches(rawPassword,user.getPassword());
    }


}