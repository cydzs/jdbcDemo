package com.cydzs.dao.impl;

import com.cydzs.commons.jdbcUtil;
import com.cydzs.dao.BaseDao;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cydzs
 * @GreateTime:2021/5/6
 **/
public class
BaseDaoImpl implements BaseDao {

    /**
     * 封装通用的DML操作
     * @param sql
     * @param param
     * @return
     */
    @Override
    public int executeUpdate(String sql, Object[] param) {
        Connection conn = null;
        PreparedStatement ps=null;
        System.out.println("sql = " + sql);
        int rows = 0;
        try {
            conn= jdbcUtil.getConnection();
            conn.setAutoCommit(false);
            ps=conn.prepareStatement(sql);
            //得到参数的个数
            ParameterMetaData pmd = ps.getParameterMetaData();
            //绑定参数
            for (int i = 0; i <pmd.getParameterCount() ; i++) {
                ps.setObject(i+1,param[i]);
            }
            rows=ps.executeUpdate();
            System.out.println("rows = " + rows);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            jdbcUtil.rollBack(conn);
        } finally {
            jdbcUtil.closeResource(ps,conn,null);
        }

        return rows;
    }

    /**
     * 完成通用查询的方法
     * <T> List<T>:泛型方法
     *注意:通用的查询方法中要求模型对象的属性名必须要和数据库表中的列名相同
     */
    @Override
    public <T> List<T> find(String sql, Object[] param, Class<T> clazz) {
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        List<T> list = new ArrayList<>();
        System.out.println("sql = " + sql);
        try {
            conn=jdbcUtil.getConnection();
            ps= conn.prepareStatement(sql);
            //得到参数的个数
            ParameterMetaData pmd = ps.getParameterMetaData();
            //绑定参数
            for (int i = 0; i <pmd.getParameterCount() ; i++) {
                ps.setObject(i+1,param[i]);
            }
            //处理结果集
            rs= ps.executeQuery();
            //获取结果集的信息
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                //完成ORM处理:通过jdk的反射
                T bean = clazz.newInstance();
                for (int i = 0; i <rsmd.getColumnCount() ; i++) {
                    //得到列名
                    String columName = rsmd.getColumnName(i+1);
                    //获取列的值
                    Object value = rs.getObject(columName);
                    //通过BeanUtil工具类将值放入到对象中
                    BeanUtils.setProperty(bean,columName,value);
                }
                list.add(bean);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closeResource(ps,conn,rs);
        }
        return list;
    }
}
