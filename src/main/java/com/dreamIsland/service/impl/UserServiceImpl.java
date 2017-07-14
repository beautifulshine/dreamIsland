package com.dreamIsland.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dreamIsland.dao.UserDao;
import com.dreamIsland.model.User;
import com.dreamIsland.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource  
    private UserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        return userDao.getUserById(userId);  
    }  
}
