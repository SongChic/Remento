package com.Remento.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Remento.Dao.UserDao;

@Service("userService")
public class UserService {
	@Autowired
	UserDao userDao;
	
	public int idCheck ( String userId ) {
		return userDao.idCheck(userId);
	}
}
