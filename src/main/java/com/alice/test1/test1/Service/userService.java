package com.alice.test1.test1.Service;

import com.alice.test1.test1.model.User;

public interface userService {
    boolean login(int id, String rawpassword) ;

   User registerUser(int id, String rawpassword);
}
