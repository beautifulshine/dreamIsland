package com.dreamIsland.dao;

import java.util.List;
import java.util.Map;

import com.dreamIsland.model.User;

public interface UserDao {
	public User getUser(String email ,String pwd);
	
	public User getUserById(Integer userId);

	public int getUserCount(Map<String, Object> data);
	
	public int getCount(Map<String, Object> map);
	
	public List<User> getUsers(Map<String, Object> map);

	public int queryzhanghaoCountsByConditons(String isForbid, String selectName);

	public List<User> queryzhanghaoByConditons(Map<String, Object> map);
	
	public int updateUser(User user);
	
	public int register(User user);
	
	public User getUserByEmail(String email);
	
	public int changeStatus(User user);
	
	public List<User> getTeamUsers(Integer teamId);
	public int addTeamMember(Integer teamId,Integer userId);
	
	public List<User> searchUser(Map<String, Object> map);

}
