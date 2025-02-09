package com.alice.test1.test1.Service;

import com.alice.test1.test1.model.User;

public interface userService {
    static boolean login(String username, String password) {
        return false;
    }

    static User registerUser(String username, String password) {
        return null;
    }
}
