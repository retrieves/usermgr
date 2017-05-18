package com.usermgr.service.impl;

import java.util.List;

import com.usermgr.entity.User;
import com.usermgr.factory.UserDaoFactory;
import com.usermgr.service.UserService;

/**
 * 业务层
 * @author oyk
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public int saveUser(User user) {
		return UserDaoFactory.getInstance().doCreate(user);
	}

	@Override
	public int deleteUser(int id) {
		//其他的业务计算
		return UserDaoFactory.getInstance().doDelete(id);
	}

	@Override
	public int updateUser(User user) {
		if(user.getSex().contains("男")){
			user.setSex("帅气男孩");
		}else{
			user.setSex("漂亮女孩");
		}
		return UserDaoFactory.getInstance().doUpdate(user);
	}

	@Override
	public User findById(int id) {
		return UserDaoFactory.getInstance().getOne(id);
	}

	@Override
	public List<User> findAll(String keyword) {
		return UserDaoFactory.getInstance().getAll(keyword);
	}

}
