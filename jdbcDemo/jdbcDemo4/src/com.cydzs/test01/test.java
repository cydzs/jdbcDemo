package com.cydzs.test01;

import com.cydzs.commons.randomUser;
import com.cydzs.pojo.User;
import com.cydzs.service.UserService;
import com.cydzs.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class test {

    public static void main(String[] args) {
        /**
        User user =new User();
        user.setName("mike");
        user.setRegistration_date("2018-05-03 12:00:00");
        user.setIntegral(20);
        user.setGender("男");
        UserService us =new UserServiceImpl();

        us.addUser(user);
         */
        /**
         * 添加1000条
        System.out.println("Math.random()*201 = " + (int)(Math.random() * 201));
        for (int i = 0; i <1000 ; i++) {
            User user =new User();UserService us =new UserServiceImpl();
            user.setName(randomUser.randomName());
            user.setRegistration_date(randomUser.randomDate());
            user.setIntegral(randomUser.randomIntegral());
            user.setGender(randomUser.randomGender());
            us.addUser(user);
        }
         */
        /**
         * 通过id删除
        UserService us =new UserServiceImpl();
        us.dropUser(3005);
         */
        /**
         * 根据id修改积分
        User user =new User();
        user.setIntegral(88);
        user.setId(1005);
        UserService us =new UserServiceImpl();
        us.modifUser(user);
         */
        /**通过id查找所有信息
        UserService us =new UserServiceImpl();
        List <User>users =us.findUser(1025);
        for(User user:users){
            System.out.println("user = " + user);
        }
         */
        /**查询积分大于的信息
        UserService us =new UserServiceImpl();
        List <User>users =us.findUserMoreIt(198);
        for(User user:users){
            System.out.println("user = " + user);
        }
        */
        UserService us =new UserServiceImpl();
        List <User>users =us.findUserByMonth(10);
        for(User user:users){
            System.out.println("user = " + user);
        }

    }
}
