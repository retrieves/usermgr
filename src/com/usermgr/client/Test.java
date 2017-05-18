package com.usermgr.client;

import com.usermgr.dao.UserDao;
import com.usermgr.dao.impl.UserDaoImpl;
import com.usermgr.entity.User;

public class Test {

	public static void main(String[] args) {
		User user = new User("aa","男",new java.util.Date());
		System.out.println(user);
		UserDao dao = new UserDaoImpl();
		/*int i = dao.doCreate(user);
		System.out.println(i);*/
		int i = dao.doDelete(3);
		System.out.println(i);
	}

}
