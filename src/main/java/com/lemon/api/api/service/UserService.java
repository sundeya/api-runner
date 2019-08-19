package com.lemon.api.api.service;

import com.lemon.api.api.pojo.User;

import java.util.List;

public interface UserService {
    public  void  add(User user) throws Exception;

    public List<User> find(User user) throws Exception;
}
