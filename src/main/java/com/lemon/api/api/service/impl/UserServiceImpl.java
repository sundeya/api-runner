package com.lemon.api.api.service.impl;

import com.lemon.api.api.dao.UserMapper;
import com.lemon.api.api.pojo.User;
import com.lemon.api.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void add(User user) throws Exception{
         userMapper.add(user);
    }

    @Override
    public List<User> find(User user) throws Exception {
        return userMapper.find(user);
    }
}
