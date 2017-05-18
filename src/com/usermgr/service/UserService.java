package com.usermgr.service;


import java.util.List;

import com.usermgr.entity.User;

public interface UserService {
	
	int saveUser(User user);
	
	int deleteUser(int id);
	
	int updateUser(User user);
	
	User findById(int id);
	
	List<User> findAll(String keyword);
}
