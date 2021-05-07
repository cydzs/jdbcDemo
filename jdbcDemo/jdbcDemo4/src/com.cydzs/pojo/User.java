package com.cydzs.pojo;

/**
 * user类属性与表列名一一对应
 * @Author: Cydzs
 * @GreateTime:2021/5/7
 **/
public class User {
    private int id;
    private String name;
    private String registration_date;
    private int integral;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", integral=" + integral +
                ", gender='" + gender + '\'' +
                '}';
    }
}
