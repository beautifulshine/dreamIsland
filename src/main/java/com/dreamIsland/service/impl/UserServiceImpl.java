package com.dreamIsland.service.impl;

import javax.annotation.Resource;

import com.dreamIsland.dao.UserDao;
import com.dreamIsland.dmo.User;

public class UserServiceImpl {
	@Resource  
    private UserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
}
