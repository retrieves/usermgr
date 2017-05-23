package com.usermgr.client;

import java.rmi.server.Operation;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.usermgr.controler.Operator;
import com.usermgr.dao.UserDao;
import com.usermgr.dao.impl.UserDaoImpl;
import com.usermgr.entity.User;
import com.usermgr.until.DateUtil;

public class Test {

	public static void main(String[] args) {
/*		User user = new User(10,"四","男",new java.util.Date());
//		System.out.println(user);
		UserDao dao = new UserDaoImpl();
		int i = dao.doCreate(user);
		System.out.println(i);
		int i = dao.doDelete(3);
		System.out.println(i);
		UserDao dao = new UserDaoImpl();
		//System.out.println(dao.getOne(5));
		
		List<User> users = dao.getAll("李");
		Iterator<User> it = users.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		User user = dao.getOne(5);
		user.setName("李5");
		dao.doUpdate(user);
		System.out.println(DateUtil.getString());*/
		
		//DateUtil.getDate("输入生日(yyyy-MM-dd)", "格式不对输出");
//		System.out.println(DateUtil.getInt("请输入整数"));
		/*Operator.save();*/
	}
	

}
