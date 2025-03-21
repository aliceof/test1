package com.alice.test1.test1.Service.impl;

import com.alice.test1.test1.Service.LoginService;
import com.alice.test1.test1.repository.UserRepository;
import com.alice.test1.test1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean login(String username, String rawpassword) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            logger.warn("用户名或密码为空");
            return false;
        }
        if (passwordEncoder.matches(rawpassword, user.getPassword())) {
            logger.info("登录成功");
        }
        return true;
    }
}

