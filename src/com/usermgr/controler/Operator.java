package com.usermgr.controler;

import java.util.Date;
import java.util.List;

import com.usermgr.entity.User;
import com.usermgr.factory.UserServiceFactory;
import com.usermgr.until.DateUtil;

public class Operator {
	
	public static void save(){
		String name = DateUtil.getString("输入姓名：");
		String sex = DateUtil.getString("输入性别：");
		Date birthday = DateUtil.getDate("输入生日（yyyy-MM-dd）");
		User user =new User(0,name,sex,birthday);
		int i = UserServiceFactory.getInstance().saveUser(user);
		 if(i>0){
			 System.out.println("用户数据保存成功");
		 }else{
			 System.out.println("用户数据保存失败");
		 }
	}
	
	public static void delete(){
		int id = DateUtil.getInt("输入要删除的编号:");
		User u = UserServiceFactory.getInstance().findById(id);
		if(u != null){
			UserServiceFactory.getInstance().deleteUser(id);
			System.out.println("删除成功！！");
		}else{
			System.out.println("不存在该编号人员信息");
		}
		
	}
	
	public static void update(){
		int i = -1;
		int id = DateUtil.getInt("输入要修改的编号:");
		User u = UserServiceFactory.getInstance().findById(id);
		if(u != null){
			u.setName(DateUtil.getString("输入姓名（原姓名:"+u.getName()+")："));
			u.setSex(DateUtil.getString("输入性别（原性别："+u.getSex()+"): " ));
			u.setBirthday(DateUtil.getDate("输入生日(原生日："+u.getBirthday()+"): "));
			i = UserServiceFactory.getInstance().updateUser(u);
		}else{
			System.out.println("不存在该编号人员信息");
		}
		if(i>0){
			System.out.println("成功修改人员信息！");
		}else{
			System.out.println("修改失败！");
		}
		
	}
	
	public static void findById(){
		int id = DateUtil.getInt("输入你要查询的编号:");
		User user = UserServiceFactory.getInstance().findById(id);
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("不存在该编号人员信息");
		}
		
	}
	public static void findByKeyword(){
		String keyword = DateUtil.getString("输入关键字：");
		List<User> list = UserServiceFactory.getInstance().findAll(keyword);
		if(list.size()>0){
			for(User u : list){
				System.out.println(u);
			}
		}else{
			System.out.println("没有数据");
		}
	}
}
