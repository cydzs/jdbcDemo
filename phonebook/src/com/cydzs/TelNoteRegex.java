package com.cydzs;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/**
 * 数据校验类
 */
public class TelNoteRegex {
    /**
     *  对菜单输入选项的验证
     * @param min
     * @param max
     */
    public int menuItemValidate (int min, int max ){
        //定义验证菜单项的正则表达式
        String regex = "\\d{1}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入正确的数字，最小是："+min+"\t"+"最大："+max);
            String input = scanner.nextLine();
            if (input.matches(regex)){
                int inputNum =Integer.parseInt(input);
                if(inputNum>=min&&inputNum<=max){
                    return inputNum  ;
                }else {
                    System.out.println("请输入范围内的数字");
                }
            }

        }

    }

    /**
     * 对用户输入姓名的验证
     * 字母大小写长度1-10之间
     * @return
     */
    public String nameValidate ( ){
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入姓名1-10个大小写字母");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("请正确输入姓名");
            }
        }
    }

    /**
     * 对输入的年龄的验证
     * 年龄的格式要求10-99
     * @return
     */
    public String ageValidate ( ){
        String regex = "[1-9]\\d?";
        Scanner scanner = new Scanner(System.in);
        while (true){

            System.out.println("请输入年龄1-99");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("请正确输入年龄");
            }
        }

    }

    /**
     * 对用户输入性别的验证
     * 性别 男（m或M） 女（F或f）
     * @return
     */
    public String sexValidate ( ){
        String regex = "[m|M|f|F]{1}";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入性别男（M或m）女（F或f）");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("请正确输入性别");
            }
        }

    }

    /**
     * 对用户输入电话号码的验证
     * 电话号码要求
     * @return
     */
    public String StelNumValidate ( ){
        String regex = "(\\d{3,4}-[1-9]\\d{6,7}|[1]\\d{10})";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入电话号码(座机或者手机号)");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("请输入正确的电话号码");
            }
        }

    }


    /**
     * 对用户输入地址的验证
     * 地址格式要求：字母或者数字长度1-50
     * @return
     */
    public String addressValidate ( ) {
        String regex = "\\w{1,50}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入地址格式 0-50字母或数字");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }
            else {
                System.out.println("请正确输入地址");
            }
        }

    }

    public static void main(String[] args) {
        TelNoteRegex regex = new TelNoteRegex();
//        int menuItem=regex.menuItemValidate(1,6);
//        System.out.println(menuItem);
//        String name = regex.nameValidate();
//        System.out.println(name);
//        String age = regex.ageValidate();
//        System.out.println(age);
//        String sex = regex.sexValidate();
//        System.out.println(sex);
//        String tel = regex.StelNumValidate();
//        System.out.println(tel);
        String addres = regex.addressValidate();
        System.out.println(addres);
    }

}
