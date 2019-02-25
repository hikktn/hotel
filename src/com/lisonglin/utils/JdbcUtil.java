package com.lisonglin.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	public static final ComboPooledDataSource ds=new ComboPooledDataSource();
	public static final Properties prop=new Properties();
	public static final QueryRunner qr =new QueryRunner();
	
	static {
		InputStream is=JdbcUtil.class.getClassLoader().getResourceAsStream("conf");
		try {
			prop.load(is);
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
			ds.setDriverClass(prop.getProperty("driver"));
			ds.setJdbcUrl(prop.getProperty("url"));
			ds.setInitialPoolSize(Integer.parseInt(prop.getProperty("init")));
			ds.setMaxPoolSize(Integer.parseInt(prop.getProperty("max")));
			ds.setMinPoolSize(Integer.parseInt(prop.getProperty("min")));
			ds.setAcquireIncrement(Integer.parseInt(prop.getProperty("acquire")));
		} catch (IOException | PropertyVetoException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
