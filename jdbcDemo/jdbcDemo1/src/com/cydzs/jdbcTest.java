package com.cydzs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest {


    public void insertDepartments(String department_name,int location_id){
        Connection conn= null;
        Statement state = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" +
                    "3306/bjsxt?useUnicode=true&characterEncoding=utf-8","root","root");
            //执行sql
            String sql="insert into departments values(default,'"+department_name+"',"+location_id+")";
            state =conn.createStatement();
            int flag = state.executeUpdate(sql);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if( state !=null){
                try {
                    state.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
    // 更新表中的数据
    public void updateDepartments (String department_name,int location_id,int department_id){
        Connection conn=null;
        Statement state =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" +
                    "3306/bjsxt?useUnicode=true&characterEncoding=utf-8","root","root");
            String sql = "update departments d set d.department_id="+department_id+",d.depart_name='"+department_name+"',d.location_id="+location_id+"\n" +
                    "where department_id=8;";
            state =conn.createStatement();
            int flag=state.executeUpdate(sql);
            System.out.println("flag = " + flag);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if( state !=null){
                try {
                    state.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) {
        jdbcTest test = new jdbcTest();
//        test.insertDepartments("销售部",4);
//        test.updateDepartments("销售部",11,7);

    }
}
