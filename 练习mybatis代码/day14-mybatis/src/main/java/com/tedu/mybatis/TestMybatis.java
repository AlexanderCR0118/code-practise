package com.tedu.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.pojo.Emp;

/**
 * Mybaits的快速入门
 */
public class TestMybatis {
	public static void main(String[] args) throws Exception {
		//1.读取mybatis核心配置文件(mybatis-config.xml)
		InputStream in = Resources.getResourceAsStream(
				"mybatis-config.xml");
		//2.通过配置信息获取SqlSessionFactory工厂
		SqlSessionFactory fac = new 
				SqlSessionFactoryBuilder().build( in );
		//3.通过工厂获取SqlSession对象
		SqlSession session = fac.openSession(); //Connection
		//4.执行sql语句, 返回处理后的结果( List<Emp> )
		List<Emp> list = session.selectList(
				"EmpMapper.findAll");
		//5.输出结果
		for (Emp emp : list) {
			System.out.println( emp );
		}
	}
}







