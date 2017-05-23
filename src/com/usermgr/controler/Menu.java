package com.usermgr.controler;

import com.usermgr.until.DateUtil;

public class Menu {
	public Menu(){
		while(true){
			this.show();
		}
	}
	private void show(){
		System.out.println("======人员信息管理系统=======");
		System.out.println("1.增加用户信息");
		System.out.println("2.修改用户信息");
		System.out.println("3.删除用户信息");
		System.out.println("4.查询单个用户信息");
		System.out.println("5.关键字查询用户信息");
		System.out.println("0.退出系统");
		
		int op = DateUtil.getInt("请选择操作：");
		switch(op){
			case 0:{
				System.out.println("已退出，谢谢使用。。。。");
				System.exit(1);
				break;
			}
			case 1:{
				Operator.save();
				break;
			}
			case 2:{
				Operator.delete();
				break;
			}
			case 3:{
				Operator.update();
				break;
			}
			case 4:{
				Operator.findById();
				break;
			}case 5:{
				Operator.findByKeyword();
				break;
			}default:{
				System.out.println("编号操作不存在");
				break;
			}
		}
	}
}
