package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.User;

/**
 * 业务层接口
 * @author Allen
 *
 */
public interface UserService {
	
		//增加
		public int insertUser(String name, String registerTime, int point, String gender);
		//删除
		public int dropUserById(int userId);
		//修改
		public int modifyUserPoint(User user);
		//通过注册月份查询
		public List<User> findUserByRgMonth(String month);
		//通过用户ID查询
		public List<User> findUserByUserId(int userId);
		//通过积分查询
		public List<User> findUserByPoint(int point);
}
