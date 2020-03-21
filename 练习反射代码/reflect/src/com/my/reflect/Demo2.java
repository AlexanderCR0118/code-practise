package com.my.reflect;

public class Demo2 {

	public static void main(String[] args) throws Exception, Exception {
		Student stu = new Student("A");
		Class stu1 = stu.getClass();
		Object stu2 = stu1.newInstance();
		System.out.println(stu);
		System.out.println(stu1);
		System.out.println(stu2);
	}
}
