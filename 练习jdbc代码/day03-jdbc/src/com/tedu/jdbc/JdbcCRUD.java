package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tedu.util.JdbcUtil;

/**
 * Jdbc的增删改查
 * 	CRUD：C(create) R(Retrieve) U(update) D(delete)
 */
public class JdbcCRUD {
	
	/** 1、新增：往account表中插入一条新的记录，
	 * name为 "john"，money为3000 */
	@Test
	public void add( ) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			conn = JdbcUtil.getConn();
			//获取传输器并执行sql语句
			stat = conn.createStatement();
			String sql = "insert into account values "
					+ "(null, 'john', 3000)";
			int rows = stat.executeUpdate( sql );
			System.out.println("影响行数: "+rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//调用工具方法释放资源
			JdbcUtil.close(conn, stat, rs);
		}
		
	}
	/** 2、修改：修改account表中name为 "john" 
	 * 的记录，将金额改为1500 */
	@Test
	public void update( ) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			conn = JdbcUtil.getConn();
			//获取传输器并执行sql语句
			stat = conn.createStatement();
			String sql = "update account set money=1500"
					+ " where name='john' ";
			int rows = stat.executeUpdate( sql );
			System.out.println( "影响行数: "+rows );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}
	}
	/** 3、删除：删除account表中name为 "john" 的记录 */
	@Test
	public void delete( ) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			conn = JdbcUtil.getConn();
			//获取传输器并执行sql语句
			stat = conn.createStatement();
			String sql = "delete from account where "
					+ "name='john'";
			int rows = stat.executeUpdate( sql );
			System.out.println( "影响行数: "+rows );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stat, rs);
		}
	}
	/** 4、查询：查询account表中id为1的记录 */
	@Test
	public void findById( ) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			conn = JdbcUtil.getConn();
			//获取传输器并执行sql
			stat = conn.createStatement();
			String sql = "select * from account where id=1";
			rs = stat.executeQuery( sql );
			//处理结果
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id+" : "+name+" : "+money);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






