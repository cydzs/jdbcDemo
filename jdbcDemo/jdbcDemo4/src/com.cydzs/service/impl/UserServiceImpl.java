package com.cydzs.service.impl;

import com.cydzs.dao.UserDao;

import com.cydzs.dao.impl.UserDaoImpl;
import com.cydzs.pojo.User;
import com.cydzs.service.UserService;

import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(User user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.insterUser(user);
    }

    @Override
    public int dropUser(int id) {
        UserDao userDao=new UserDaoImpl();
        return userDao.deleteUserById(id);
    }

    @Override
    public int modifUser(User user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.updateUserIntegral(user);
    }

    @Override
    public List<User> findUser(int id) {
        UserDao userDao=new UserDaoImpl();
        return userDao.selectUserById(id);
    }

    @Override
    public List<User> findUserMoreIt(int integral) {
        UserDao userDao=new UserDaoImpl();
        return userDao.selectUserMoreIntegral(integral);
    }

    @Override
    public List<User> findUserByMonth(int month) {
        UserDao userDao=new UserDaoImpl();
        return userDao.selectUserByMonth(month);
    }
}
