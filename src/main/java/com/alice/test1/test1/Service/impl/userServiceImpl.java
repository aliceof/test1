package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.userService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class userServiceImpl implements userService{
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public userServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        this.userMapper=userMapper;
    }

    @Override
    public User registerUser(int id,String rawPassword){
        if (userMapper.findById(id)!=null){
            throw new IllegalArgumentException("このユーザー名は既に使われている");
        }
        User user=new User();
        user.setId(id);
        user.setPassword((passwordEncoder.encode(rawPassword)));
        return userMapper.save(user);
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