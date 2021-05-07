package com.cydzs.test01;

import java.util.Random;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class test02 {
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("(new Random().nextInt(1)) = " + (new Random().nextInt(2) ));
        }


    }
}
