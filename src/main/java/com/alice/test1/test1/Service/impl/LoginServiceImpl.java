package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.LoginService;
import com.alice.test1.test1.mapper.UserMapper;
import com.alice.test1.test1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override

    public boolean login(String username, String rawpassword){
        User user = userMapper.findUserByName(username);
        if (user==null) {
            return false;
        }
        return passwordEncoder.matches(rawpassword, user.getPassword());
    }
}
