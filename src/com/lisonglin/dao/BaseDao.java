package com.lisonglin.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lisonglin.utils.JdbcUtil;
import com.lisonglin.utils.ProxyUtil;

public class BaseDao<T> {
	/**
	 * 查询一个对象
	 * @throws SQLException 
	 */
	public T get(String sql,Object ...args) throws SQLException {
		Connection conn = ProxyUtil.tl.get();
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType) genericSuperclass;
		Class c= (Class) pt.getActualTypeArguments()[0];
		BeanHandler<T> rsh=new BeanHandler<>(c);
		T t= JdbcUtil.qr.query(conn,sql, rsh,args);
		return t;
	}
	
	/**
	 * 查询一个值
	 * @throws SQLException 
	 */
	public Object getValue(String sql,Object ...args) throws SQLException {
		Connection conn = ProxyUtil.tl.get();
		ScalarHandler<T> rsh =new ScalarHandler<>();
		T t=JdbcUtil.qr.query(conn, sql, rsh,args);
		return t;
	}
	/**
	 * 查询多个对象
	 * @throws SQLException 
	 */
	public List<T> getAll(String sql,Object ...args) throws SQLException{
		Connection conn = ProxyUtil.tl.get();
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType) genericSuperclass;
		Class c= (Class) pt.getActualTypeArguments()[0];
		BeanListHandler<T> rsh=new BeanListHandler<>(c);
		List<T> list = JdbcUtil.qr.query(conn, sql, rsh,args);
		return list;
	}
	
	/**
	 * 增加
	 * @throws SQLException 
	 */
	public void addAll(String sql,Object ...args) throws SQLException {
		Connection conn = ProxyUtil.tl.get();
		JdbcUtil.qr.update(conn, sql, args);
	}
	
	/**
	 * 删除
	 * @throws SQLException 
	 */
	public int deteleAll(String sql,Object ...args) throws SQLException {
		Connection conn= ProxyUtil.tl.get();
		int update = JdbcUtil.qr.update(conn, sql, args);
		return update;
	}
	
	/**
	 * 修改
	 */
	public void updateAll(String sql,Object ...args) throws SQLException {
		Connection conn = ProxyUtil.tl.get();
		JdbcUtil.qr.update(conn, sql, args);
	}
}
