package com.usermgr.dao;

import java.util.List;

import com.usermgr.entity.User;

public interface UserDao {
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	int doCreate(User user); //等价于 public abstract int doCreate(User user);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int doDelete(int id);
	
	int doUpdate(User user);
	
	User getOne(int id);
	
	List<User> getAll(String keyWord);
}
