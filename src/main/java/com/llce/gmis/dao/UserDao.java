package com.llce.gmis.dao;

import com.llce.gmis.entity.User;

public interface UserDao {

	public User queryUserByUserName(String userName);
	
	public int insertUser(User user);
	
	public void deleteUser(int userId);
	
}
