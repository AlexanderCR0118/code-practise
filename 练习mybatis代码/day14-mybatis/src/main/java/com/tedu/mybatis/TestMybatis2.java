package com.tedu.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatis2 {
	private static SqlSession session = null;
	static {
		try {
			//1.读取mybatis核心配置文件(mybatis-config.xml)
			InputStream in = Resources.getResourceAsStream(
					"mybatis-config.xml");
			//2.通过配置信息获取SqlSessionFactory工厂
			SqlSessionFactory fac = new 
					SqlSessionFactoryBuilder().build( in );
			session = fac.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 练习2: 新增员工信息: 刘德华 歌手 888 */
	@Test
	public void testInsert() {
		//执行sql语句, 返回处理后的结果
		int rows = session.update("EmpMapper.insert");
		//提交事务
		session.commit();
		System.out.println("影响行数: "+rows);
	}
	
	/** 练习3：修改员工信息, 将刘德华的job改为'歌手&演员' 
	 * salary改为88888 */
	@Test
	public void testUpdate() {
		//执行sql语句, 返回处理后的结果
		int rows = session.update("EmpMapper.update");
		//提交事务
		session.commit();
		System.out.println("影响行数: "+rows);
	}
	
	/** 练习4: 删除name为'刘德华'的记录 */
	
}






