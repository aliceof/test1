package com.alice.test1.test1.mapper;


import com.alice.test1.test1.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(int id);
@Insert("INSERT INTO users(username,rawpassword) VALUES(#{username},#{rawpassword})")
    User save(User user);
}
