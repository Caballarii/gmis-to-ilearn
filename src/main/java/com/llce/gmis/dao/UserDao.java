package com.llce.gmis.dao;

import com.llce.gmis.entity.User;

public interface UserDao {

	public User queryUserByUserName(String userName);
	
}
