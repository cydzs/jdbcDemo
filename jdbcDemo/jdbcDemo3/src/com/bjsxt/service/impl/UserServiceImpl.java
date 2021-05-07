package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int insertUser(String name, String registerTime, int point, String gender) {
		UserDao usDao = new UserDaoImpl();
		return usDao.addUser(name, registerTime, point, gender);
	}

	@Override
	public int dropUserById(int userId) {
		UserDao usDao = new UserDaoImpl();
		return usDao.deleteUserById(userId);
	}

	@Override
	public int modifyUserPoint(User user) {
		UserDao usDao = new UserDaoImpl();
		return usDao.updateUserPoint(user);
	}

	@Override
	public List<User> findUserByRgMonth(String month) {
		UserDao usDao = new UserDaoImpl();
		return usDao.selectUserByRgMonth(month);
	}

	@Override
	public List<User> findUserByUserId(int userId) {
		UserDao usDao = new UserDaoImpl();
		return usDao.selectUserByUserId(userId);
	}

	@Override
	public List<User> findUserByPoint(int point) {
		UserDao usDao = new UserDaoImpl();
		return usDao.selectUserByPoint(point);
	}

}
