package com.my.reflect;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		Class s = Class.forName("com.my.reflect.Student");
		System.out.println(s);
		System.out.println("------");
		
		Class st = Student.class;
		System.out.println(st);
		System.out.println("------");
		
		Student stu = new Student();
		Class stu1 = stu.getClass();
		System.out.println(stu1);
		System.out.println("-------");
		
		Student stu2 = new Student("A");
		Class stu3 = stu2.getClass();
		System.out.println(stu2);
		System.out.println(stu3);
		System.out.println("-------");
	}
}
