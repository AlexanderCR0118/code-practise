package com.tedu.pojo;
/**
 * POJO：简单Java对象，
 * 作用是用于封装数据
 * 使用包装类型代替基本数据类型，是因为
 * 基本数据类型有默认值，容易造成歧义。
 */
public class Emp {
	private Integer id;
	private String name;
	private String job;
	private Double salary;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}
}









