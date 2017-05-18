package com.usermgr.controler;

import java.util.Date;

import com.usermgr.entity.User;
import com.usermgr.factory.UserServiceFactory;
import com.usermgr.until.DateUtil;

public class Operator {
	
	public static void save(){
		String name = DateUtil.getString("输入姓名：","姓名不能为空，重新输入");
		String sex = DateUtil.getString("输入性别：","性别不能为空，请重新输入");
		Date birthday = DateUtil.getDate();
		User user =new User(0,name,sex,birthday);
		int i = UserServiceFactory.getInstance().saveUser(user);
		 if(i>0){
			 System.out.println("用户数据保存成功");
		 }else{
			 System.out.println("用户数据保存失败");
		 }
	}
}
