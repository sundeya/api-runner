package com.lemon.api.api.pojo;

public class User {
   private String id;
   private String username;
   private String password;
   private String regtime;

    public User(String id, String username, String password, String regtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regtime = regtime;
    }

    public User(String username, String password, String regtime) {
        this.username = username;
        this.password = password;
        this.regtime = regtime;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }
}
