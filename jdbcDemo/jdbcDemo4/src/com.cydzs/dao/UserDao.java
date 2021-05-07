package com.cydzs.dao;

import com.cydzs.pojo.User;

import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public interface UserDao extends BaseDao{
    public int insterUser(User user);
    public int deleteUserById(int id);
    public int updateUserIntegral(User user);
    public List<User> selectUserById(int id);
    public List<User> selectUserMoreIntegral(int integral);
    public List<User> selectUserByMonth(int month);

}
