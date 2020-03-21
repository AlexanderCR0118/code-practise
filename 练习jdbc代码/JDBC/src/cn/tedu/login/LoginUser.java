package cn.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



import cn.tedu.util.JdbcUtil;

public class LoginUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.提示用户登录
		System.out.println("请登录!");
		
		//2.提示用户输入用户名
		System.out.println("请输入用户名!");
		String name = sc.nextLine();
		
		//3.提示用户输入密码
		System.out.println("请输入密码！");
		String password = sc.nextLine();
		
		//4.根据用户名密码查询数据库
		//Login(name, password);
		loginByPreparedStatement(name,password);
		
	}

	private static void loginByPreparedStatement(
			String name, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConn();
			String sql = "select * from user where name = ? and password = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, password);			
			rs = st.executeQuery();
			if (rs.next()) {
				System.out.println("登录成功！");
			} else {
				System.out.println("用户名或密码不正确！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void Login(String name, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConn();
			st = conn.createStatement();
			String sql = 
					"select * from user where name = '"+name+"' and password = '"+password+"'" ;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println("登陆成功！");
			} else {
				System.out.println("用户名或明码不正确！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
	}
}














































