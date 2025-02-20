package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.RegisterService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private  UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


  @Override
    public User registerUser(String username, String rawpassword){
        if (userMapper.findUserByName(username)!=null){
            throw new IllegalArgumentException("このユーザー名は既に使われている");
        }
        User user=new User();
        user.setName(username);
        user.setPassword((passwordEncoder.encode(rawpassword)));
        return userMapper.saveUser(username, rawpassword);
    }



}