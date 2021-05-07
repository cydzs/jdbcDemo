package com.cydzs.dao.impl;

import com.cydzs.dao.UserDao;
import com.cydzs.pojo.User;

import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    //添加一条数据
    @Override
    public int insterUser(User user) {
        String sql = "insert into user values (default,?,?,?,?)";
        Object[] pram =new Object[]{user.getName(),user.getRegistration_date(),user.getIntegral(),user.getGender()};
        return this.executeUpdate(sql,pram);
    }

    //根据id删除
    @Override
    public int deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        Object[] pram =new Object[]{id};
        return this.executeUpdate(sql,pram);
    }

    //通过id修改积分
    @Override
    public int updateUserIntegral(User user) {
        String sql ="update user set integral=? where id=?";
        Object[] pram = new Object[]{user.getIntegral(),user.getId()};
        return this.executeUpdate(sql,pram);
    }

    //通过id查信息
    @Override
    public List<User> selectUserById(int id) {
        String sql ="select * from user where id = ?";
        Object[] param = new Object[]{id};
        return this.find(sql,param,User.class);
    }

    //查询积分大于某个值的所有数据
    @Override
    public List<User> selectUserMoreIntegral(int integral) {
        String sql ="select * from user where integral > ?";
        Object[] param = new Object[]{integral};
        return this.find(sql,param,User.class);
    }

    @Override
    public List<User> selectUserByMonth(int month) {
        String sql ="select *from user where month(registration_date)=?";
        Object[] param = new Object[]{month};
        return this.find(sql,param,User.class);
    }
}
