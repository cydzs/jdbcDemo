package com.bjsxt.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.bjsxt.commons.JdbcUtil;
import com.bjsxt.dao.BaseDao;


public class BaseDaoImpl implements BaseDao {
	/**
	 * 通用DML操作具体实现
	 */
	@Override
	public int executeUpdate(String sql, Object[] param) {
		Connection conn = null;
		PreparedStatement ps = null;
		//返回操作的行数
		int rows = 0;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			//获取参数个数
			ParameterMetaData pmd = ps.getParameterMetaData();
			//绑定参数
			for(int i=0;i<pmd.getParameterCount();i++) {
				ps.setObject(i+1, param[i]);
			}
			rows = ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.closeResources(ps, conn, null);
		}
		return rows;
	}

	@Override
	public <T> List<T> find(String sql, Object[] param, Class<T> clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//获取参数个数
			ParameterMetaData pmd = ps.getParameterMetaData();
			//绑定参数
			for(int i=0;i<pmd.getParameterCount();i++) {
				ps.setObject(i+1, param[i]);
			}
			//处理结果集
			rs = ps.executeQuery();
			//获取结果集信息
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				//完成ORM处理，通过JDK反射
				T bean = clazz.newInstance();
				for(int i=0;i<rsmd.getColumnCount();i++) {
					//得到列名
					String columnName = rsmd.getColumnName(i+1);
					Object value = rs.getObject(columnName);
					//通过BeanUtil工具放入类
					BeanUtils.setProperty(bean, columnName, value);
				}
				//存入list中
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResources(ps, conn, rs);
		}
		return list;
	}

}
