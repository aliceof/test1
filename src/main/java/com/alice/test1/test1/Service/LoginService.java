package com.alice.test1.test1.Service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface LoginService {
    @RequestMapping("/login")
    boolean login(String username, String rawPassword);
}
