package com.llce.gmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llce.gmis.dao.UserDao;
import com.llce.gmis.entity.User;

@Service("gmisService")
public class GmisService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	
	
}
