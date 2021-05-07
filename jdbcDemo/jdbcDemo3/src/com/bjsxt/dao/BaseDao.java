package com.bjsxt.dao;

import java.util.List;

/**
 * DML 通用操作接口
 * @author Allen
 *
 */
public interface BaseDao {
	
	//表数据更新操作
	public int executeUpdate(String sql, Object[] param);
	//表数据查询操作
	public <T>List<T> find(String sql, Object[] param, Class<T> clazz);
}
