package com.llce.gmis.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llce.gmis.dao.UserDao;
import com.llce.gmis.entity.User;
import com.llce.gmis.entity.UserRole;
import com.llce.gmis.utils.encoder.Base64Utils;

@Service("gmisService")
public class GmisService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	public int addUser(User user){
		//user.setPasswordHash(Base64Utils.encode(user.getPasswordHash()));
		user.setEmail("");
		user.setPasswordQuestion("");
		user.setPasswordAnswer("");
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		user.setLastLoginDate(new Date());
		user.setLastActivityDate(new Date());
		user.setLoginKey("");
		user.setRole(UserRole.valueOf(0));
		user.setDisabled(false);
		user.setDeleted(false);
		user.setLastLoginAttemptDate(new Date());
		user.setLoginAttemptionCount(0);
		user.setHeadPicB("/files/img/user/initial/initial_b.gif");
		user.setHeadPicS("/files/img/user/initial/initial_s.gif");
		return userDao.insertUser(user);
	}
	
}
