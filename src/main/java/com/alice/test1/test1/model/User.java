package com.alice.test1.test1.model;


public class User {
    private String username;

    private String rawpassword;



    public void setPassword(String rawpassword){
        this.rawpassword=rawpassword;
    }
    public String getPassword(){
        return rawpassword;
    }

    public void setName(String username) {
    }
    public String getName(){
        return username;
    }
}
