package com.bjsxt.dao.impl;

import java.util.List;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	//增加操作
	@Override
	public int addUser(String name, String registerTime, int point, String gender) {
		String sql = "insert into users values(default,?,?,?,?)";
		Object[] param = new Object[] {name, registerTime, point, gender};
		return this.executeUpdate(sql, param);
	}
	//通过用户ID删除
	@Override
	public int deleteUserById(int userId) {
		String sql = "delete from users where 用户ID = ?";
		Object[] param = new Object[] {userId};
		return this.executeUpdate(sql, param);
	}
	//修改积分
	@Override
	public int updateUserPoint(User user) {
		String sql = "update users set 积分 = ? where 昵称 = ?";
		Object[] param = new Object[] {user.get积分(), user.get昵称()};
		return this.executeUpdate(sql, param);
	}
	//通过用户注册月份查询
	@Override
	public List<User> selectUserByRgMonth(String month) {
		String sql = "select * from users where MONTH(注册时间) = ?";
		Object[] param = new Object[] {month};
		return this.find(sql, param, User.class);
	}
	//通过用户ID查询
	@Override
	public List<User> selectUserByUserId(int userId) {
		String sql = "select * from users where 用户ID = ?";
		Object[] param = new Object[] {userId};
		return find(sql, param, User.class);
	}
	//查询积分大于100的用户
	@Override
	public List<User> selectUserByPoint(int point) {
		String sql = "select * from users where 积分 > ?";
		Object[] param = new Object[] {point};
		return find(sql, param, User.class);
	}

}
