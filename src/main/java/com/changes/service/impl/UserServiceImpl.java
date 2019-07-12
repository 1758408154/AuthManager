package com.changes.service.impl;

import com.changes.bean.User;
import com.changes.mapper.UserMapper;
import com.changes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuJunJie
 * @since 2019/7/1 15:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(String userName) {
        User u = new User();
        u.setUserName(userName);
        return userMapper.selectOne(u);
    }
}
