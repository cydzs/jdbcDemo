package com.cydzs.commons;

import java.util.Random;

/**
 * 随机生成user属性
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class randomUser {
    public static String randomName() {
        StringBuilder sb = new StringBuilder();
        char c = (char) ('A' + Math.random() * 26);
        char c1 = (char) ('a' + Math.random() * 26);
        char c2 = (char) ('a' + Math.random() * 26);
        sb.append(c).append(c1).append(c2);
        return sb.toString();
    }

    public static String randomDate() {
        Random rndMonth = new Random();
        int month = rndMonth.nextInt(12) + 1;
        Random rndDay = new Random();
        int Day = rndDay.nextInt(28) + 1;
        Random rndHour = new Random();
        int hour = rndHour.nextInt(23);
        Random rndMinute = new Random();
        int minute = rndMinute.nextInt(60);
        Random rndSecond = new Random();
        int second = rndSecond.nextInt(60);
        return 2018 + "-" + month + "-" + Day + " " + hour + ":" + minute + ":" + second;
    }

    public static int randomIntegral(){
        return (int)(Math.random()*201);
    }
    public static String randomGender(){

        return (new Random().nextInt(2))==0?"女":"男";
    }
}