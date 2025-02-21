package com.alice.test1.test1.mapper;


import com.alice.test1.test1.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserByName(String username);
    User saveUser(String username,String rawpassword);
}
