package com.my.reflect;

public class Student {

	private String name;
	private Integer id;
	public Integer age;
	
	static {
		System.out.println("加载进jvm中");
	}

	public Student() {
		super();
		System.out.println("调用无参构造方法创建了一个学生对象");
	}

	public Student(String name) {
		super();
		this.name = name;
		System.out.println("调用带一个参数的构造方法创建了一个学生对象");
	}

	public Student(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
		System.out.println("调用带两个参数的构造方法创建了一个学生对象");
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void A() {
		System.out.println("你好，我是："+ this.name);
	}
	
	public void B(String name) {
		System.out.println(name + "你好，我是！" + this.name);
	}
}
















































































