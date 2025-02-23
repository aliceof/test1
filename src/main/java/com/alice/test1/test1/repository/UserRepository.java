package com.alice.test1.test1.repository;

import com.alice.test1.test1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findUserByUsername(String username);
    User save(User user);
}
