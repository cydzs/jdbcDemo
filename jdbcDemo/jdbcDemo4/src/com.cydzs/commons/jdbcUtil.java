package com.cydzs.commons;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * jdbc 工具类
 */
public class jdbcUtil {
    private static String driver ;
    private static String jdbcUrl ;
    private static String userName;
    private static String userPassword;

    static{
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        driver = bundle.getString("driver");
        jdbcUrl = bundle.getString("jdbcUrl");
        userName = bundle.getString("userName");
        userPassword = bundle.getString("userPassword");
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取Connection对象
    public static Connection getConnection(){
        Connection conn =null;
        try {
            return DriverManager.getConnection(jdbcUrl,userName,userPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    //关闭Statement
    public static void  closeStatement(Statement state){
        try {
            if (state!=null){
                state.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //关闭Connection
    public static void closeConnection(Connection conn){
        try {
            if (conn !=null){
                conn.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //关闭ResultSet
    public static void closeResultSet(ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //关闭资源
    public static void closeResource(Statement state,Connection conn,ResultSet rs){
        closeStatement(state);
        closeConnection(conn);
        closeResultSet(rs);
    }
    //回滚事物
    public static void rollBack(Connection conn){
        try {
            if (conn!=null){
                conn.rollback();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
