package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.User;

import java.util.List;

public interface UserMapper {

    public void add(User user) throws Exception;

    public List<User> find(User user) throws Exception;
}
