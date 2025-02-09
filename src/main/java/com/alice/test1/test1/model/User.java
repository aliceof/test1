package com.alice.test1.test1.model;


public class User {
    private String username;
    private int id;
    private String rawpassword;

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){return id;}
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String rawpassword){
        this.rawpassword=rawpassword;
    }
    public String getPassword(){
        return rawpassword;
    }
}
