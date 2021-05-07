package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.User;

/**
 * User接口
 * @author Allen
 *
 */
public interface UserDao extends BaseDao {
	//增加
	public int addUser(String name, String registerTime, int point, String gender);
	//删除
	public int deleteUserById(int userId);
	//修改
	public int updateUserPoint(User user);
	//通过注册月份查询
	public List<User> selectUserByRgMonth(String month);
	//通过用户ID查询
	public List<User> selectUserByUserId(int userId);
	//通过积分查询
	public List<User> selectUserByPoint(int point);
}
