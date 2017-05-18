package com.usermgr.factory;

import com.usermgr.dao.UserDao;
import com.usermgr.dao.impl.UserDaoImpl;

public class UserDaoFactory {

	public static UserDao getInstance() {
		return new UserDaoImpl();
	}

}
