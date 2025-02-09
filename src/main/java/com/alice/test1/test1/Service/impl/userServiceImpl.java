package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.userService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class userServiceImpl implements userService{
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public userServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        this.userMapper=userMapper;
    }

    @Override
    @RequestMapping("/register")
    public User registerUser(String username, String rawPassword){
        if (userMapper.findByUsername!=null){
            throw new IllegalArgumentException("このユーザー名は既に使われている");
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword((passwordEncoder.encode(rawPassword)));
        return userMapper.save(user);
    }
    @Override
    @RequestMapping("/login")
    public Boolean login(String username,String rawPassword){
        User user = UserMapper.findByUsername(username);
        if (user==null){
            return false;
        }
        return passwordEncoder.matches(rawPassword,user.getPassword());
    }
}
