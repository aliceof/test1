package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.RegisterService;
import com.alice.test1.test1.repository.UserRepository;
import com.alice.test1.test1.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;
    private final static Logger logger= LogManager.getLogger(RegisterServiceImpl.class);
    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


  @Override
    public User registerUser(String username, String rawpassword){
        if (userRepository.findUserByUsername(username)!=null){
            logger.error("用户名已存在");
            throw new IllegalArgumentException("このユーザー名は既に使われている");
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword((passwordEncoder.encode(rawpassword)));
        logger.info("用户注册成功");
        return userRepository.save(user);
    }
}