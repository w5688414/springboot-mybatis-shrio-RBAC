package com.ccnu.shirodemo.sevice.impl;


import com.ccnu.shirodemo.entity.UserInfo;
import com.ccnu.shirodemo.mapper.UserMapper;
import com.ccnu.shirodemo.sevice.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userMapper.findByUsername(username);
    }

    @Override
    public UserInfo save(UserInfo user) {
        return userMapper.save(user);
    }
}