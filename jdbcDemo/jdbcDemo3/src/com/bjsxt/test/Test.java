package com.bjsxt.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;

/**
 * 测试类
 * @author Allen
 *
 */
public class Test {
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		/*User user = new User();
		user.setName("iaw");
		user.setPoint(50);*/
		//创建1000个不重复名字的数组
		/*String [] name = createName(1000);
		//创建1000个日期
		String [] date = createDate(1000);
		//创建1000个0-200的随机数
		int[] point = new int[1000];
		for(int i=0;i<1000;i++) {
			point[i] = (int)(Math.random()*201);
		}
		//测试随机是否成功
		//System.out.println(name[1]+" "+date[1]+" "+point[1]);
		//1. 增加操作
		for(int i=0;i<1000;i++) {
			us.insertUser(name[i], date[i], point[i], i%2==0?"男":"女");
		}*/
		//us.dropUserById(1004);
		//us.modifyUserPoint(user);
		//List<User> list = us.findUserByRgMonth("12");
		//List<User> list = us.findUserByUserId(1005);
		List<User> list = us.findUserByPoint(100);
		for(User user:list) {
			System.out.println(user.get用户ID()+"	"+user.get昵称()+"	"+user.get注册时间()+"		"+user.get积分()+" 	"+user.get性别());
		}
	}
	//创建名字的方法
	public static String[] createName(int count) {
		String[] name = new String[count];
		int num = 0;
		while(num<count) {
			char c1 = (char)('a'+Math.random()*('z'-'a'+1));
			char c2 = (char)('a'+Math.random()*('z'-'a'+1));
			char c3 = (char)('a'+Math.random()*('z'-'a'+1));
			String str = ""+c1+c2+c3;
			if(!contains(name, str)) {
				name[num] = str;
				num++;
			}
		}
		return name;
	}
	//判断名字是否重复的方法
	public static boolean contains(String[] name, String str) {
		for(String s:name) {
			if(str.equals(s)) {
				return true;
			}
		}
		return false;
	}
	//创建不同月份的日期
	public static String[] createDate(int count) {
		String[] date = new String[count];
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date startDate = sf.parse("2018-01-01 00:00:00");
			Date endDate = sf.parse("2019-01-01 00:00:00");
			long startTime = startDate.getTime();
			long endTime = endDate.getTime();
			long time = endTime - startTime;
			for(int i=0;i<count;i++) {
				date[i] = sf.format(new Date(startTime + (long)(Math.random()*time)));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
