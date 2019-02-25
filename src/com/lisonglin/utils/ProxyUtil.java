package com.lisonglin.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ProxyUtil {
	/**
	 * 动态代理
	 * 
	 * 类加载器 1、应用类加载器 2、扩展类加载器 3、系统类加载器
	 * 
	 * 获取一个代理的对象 1、被代理的类 2、接口 3、InvocationHandler
	 */
	public static final ThreadLocal<Connection> tl=new ThreadLocal<>();
	
	// 动态代理
	public static Object getProxy(Object target) {
		InvocationHandler in=new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("代理中");
				// 创建一个链接
				Connection conn = JdbcUtil.getConnection();
				// 设置为不直接提交
				conn.setAutoCommit(false);
				// 链接放入ThreadLocal
				tl.set(conn);
				Object result=null;
				try {
					result = method.invoke(target, args);
					conn.commit();
				}catch (Exception e) {
					System.err.println("执行错误,回滚");
					// 回滚。上一次提交状态
					conn.rollback();
				}
				return result;
			}
		};
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), in);
	}
}
