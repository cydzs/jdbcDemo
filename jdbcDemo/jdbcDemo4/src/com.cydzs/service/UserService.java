package com.cydzs.service;

import com.cydzs.pojo.User;

import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public interface UserService {
    public int addUser(User user);
    public int dropUser(int id);
    public int modifUser(User user);
    public List<User> findUser(int id);
    public List<User> findUserMoreIt(int integral);
    public List<User> findUserByMonth(int month);
}
