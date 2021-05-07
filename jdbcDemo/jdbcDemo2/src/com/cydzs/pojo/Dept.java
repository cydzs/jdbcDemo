package com.cydzs.pojo;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/6
 **/
public class Dept {
    private int department_id;
    private String depart_name;
    private int location_id;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "department_id=" + department_id +
                ", depart_name='" + depart_name + '\'' +
                ", location_id=" + location_id +
                '}';
    }
}
