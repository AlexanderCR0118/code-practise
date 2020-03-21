package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tedu.pojo.Emp;

/**
 * Jdbc回顾, 缺点
 * (1) 代码过于繁琐（注册驱动、获取连接、获取传输器、执行sql、释放资源）
 * (2) Jdbc自身没有连接池，效率低下（可以使用第三方的连接池）
 * (3) 通过Jdbc执行的sql语句，是写死在程序中的。
 * (4) 使用Jdbc对结果集的处理过于麻烦。
 */
public class TestJdbc {
	/* 查询yonghedb库中的emp表中的所有员工信息,
	 * 将查询到员工信息封装到Emp对象中。再将多个
	 * 员工对象添加到一个List集合中。
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql:///yonghedb?characterEncoding=utf-8", 
					"root", "root");
			//获取传输器
			stat  = conn.createStatement();
			//执行sql语句,返回执行结果
			String sql = "select * from emp";
			rs = stat.executeQuery( sql );
			//处理结果
			List<Emp> list = new ArrayList<Emp>();
			while( rs.next() ) {
				Emp emp = new Emp();
				emp.setId( rs.getInt("id") );
				emp.setName( rs.getString("name") );
				emp.setJob( rs.getString("job") );
				emp.setSalary( rs.getDouble("salary") );
				//将Emp对象添加到集合中
				list.add( emp );
			}
			//遍历List集合
			for (Emp emp : list) {
				System.out.println( emp );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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





