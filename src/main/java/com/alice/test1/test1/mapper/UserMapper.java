package com.alice.test1.test1.mapper;


import com.alice.test1.test1.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    List<User> findByUsername(String username);
@Insert("INSERT INTO users(username,rawpassword) VALUES(#{username},#{rawpassword})")
    User save(User user);
}
