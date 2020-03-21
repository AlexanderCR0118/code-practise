package cn.tedu.dbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCdemo2 {


	public static void main(String[] args) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//1.注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db10?characterEncoding = utf-8",
					"root","123456");
			//3.获取传输器
			st = conn.createStatement();
			//4.利用传输器发送SQL到数据库执行，并返回执行结果
			rs = st.executeQuery("select * from emp");
			//5.处理结果:将表中所有的记录输出在控制台
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String dept = rs.getString("dept");
				String job = rs.getString("job");
				double sal = rs.getDouble("sal");
				double bonus = rs.getDouble("bonus");
				System.out.println(id + ":" + name + ":" + gender + ":" + birthday  + 
						":" + dept + ":" + job + ":" + sal + ":" + bonus
						);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null) {
				rs.close();
			}
		}

	}
}
