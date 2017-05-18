package com.usermgr.factory;


import com.usermgr.service.UserService;
import com.usermgr.service.impl.UserServiceImpl;

public class UserServiceFactory {

	public static UserService getInstance(){
		return new UserServiceImpl();
		
	};
	
}
