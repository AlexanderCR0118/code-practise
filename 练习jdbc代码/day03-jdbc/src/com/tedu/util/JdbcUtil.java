package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Jdbc工具类
 */
public class JdbcUtil {
	/***
	 * 注册驱动并获取连接
	 * @return Connection 连接对象
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception {
		//1.注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql:///jt_db?characterEncoding=utf-8", 
				"root", "root");
		return conn;
	}
	
	/**
	 * 释放Jdbc程序中的资源
	 * @param conn 连接对象
	 * @param stat 传输器对象
	 * @param rs 结果集对象
	 */
	public static void close(
		Connection conn, Statement stat, ResultSet rs) {
		//6.释放资源
		if( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if( stat != null ) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stat = null;
			}
		}
		if( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	
}



