package com.alice.test1.test1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String rawpassword;

    public void setId(Integer id){
    this.id=id;
    }

    public Integer getId(){
    return id;
    }

    public void setPassword(String rawpassword){
        this.rawpassword=rawpassword;
    }
    public String getPassword(){
        return rawpassword;
    }

    public void setUsername(String username) {
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
}
