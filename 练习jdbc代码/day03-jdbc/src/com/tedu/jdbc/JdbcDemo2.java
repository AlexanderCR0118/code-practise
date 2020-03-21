package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Jdbc的快速入门程序
 */
public class JdbcDemo2 {
	public static void main(String[] args)  {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//1.注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			conn = DriverManager.getConnection(
					"jdbc:mysql:///jt_db?characterEncoding=utf-8", 
					"root", "root");
			//3.获取传输器
			stat = conn.createStatement();
			//4.发送sql到服务器执行,并返回结果
			String sql = "select * from account";
			rs = stat.executeQuery(sql);
			//5.处理结果(打印到控制台)
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(
						id+" : "+name+" : "+money );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
}

