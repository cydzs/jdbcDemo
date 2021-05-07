package com.bjsxt.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 * @author Allen
 *
 */
public class JdbcUtil {
	private static String driver;
	private static String jdbcUrl;
	private static String username;
	private static String userpassword;
	//读取properties文件
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		jdbcUrl = bundle.getString("jdbcUrl");
		username = bundle.getString("username");
		userpassword = bundle.getString("userpassword");
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取Connection对象
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcUrl, username, userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	 //关闭Connection连接
    public static void closeConn(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭Statement连接
    public static void closeStatement(Statement state){
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    //关闭ResultSet连接
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭数据库所有连接对象
    public static void closeResources(Statement state, Connection conn, ResultSet rs){
        closeStatement(state);
        closeConn(conn);
        closeResultSet(rs);
    }
	//事务回滚
		public static void rollback(Connection conn) {
			try {
				if(conn!=null) {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
