package com.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.tedu.util.JdbcUtil;

/**
 * 模拟学生信息管理系统
 */
public class StudentManager2 {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			//提示用户选择选项进行操作
			System.out.println("请选择以下其中一个选项进行操作: ");
			System.out.print("a) 查询学生信息\t");
			System.out.print("b) 新增学生信息\t");
			System.out.print("c) 修改学生信息\t");
			System.out.println("d) 删除学生信息");
			String opt = in.nextLine();
			if("a".equalsIgnoreCase( opt )) {
				//查询所有学生信息
				findAll();
			} else if("b".equalsIgnoreCase( opt )) {
				//新增学生信息
			}else if("c".equalsIgnoreCase( opt )) {
				//修改学生信息
			}else if("d".equalsIgnoreCase( opt )) {
				//删除学生信息
			}else {
				System.out.println("您输入的内容有误, 请重新输入!!");
			}
		}
	}
	/** 查询所有学生信息 */
	private static void findAll() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//注册驱动并获取连接
			conn = JdbcUtil.getConn();
			//获取传输器并执行sql
			stat = conn.createStatement();
			String sql = "select * from stu";
			rs = stat.executeQuery( sql );
			//处理结果
			while(rs.next()) {
				String stuid = rs.getString("stuid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String addr = rs.getString("addr");
				double score = rs.getDouble("score");
				System.out.println(stuid+" : "+name+" : "
						+gender+" : "+addr+" : "+score);
				System.out.println("------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






