package com.alice.test1.test1.mapper;


import com.alice.test1.test1.model.User;

import java.util.List;

public interface UserMapper {
    List<User> findByUsername();
}
