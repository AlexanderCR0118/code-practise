package cn.tedu.dbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.tedu.util.JdbcUtil;

public class JdbcCRUD {

	@Test
	public void add() {
		Connection conn =null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConn();
			st = conn.createStatement();
			String sql = 
					"insert into emp values" + 
			"(null,'wangkai','m','2022-2-2','peiyou','haha',10.20,20.32)";
			int rows = st.executeUpdate(sql);
			System.out.println(rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
	}
}






























































































