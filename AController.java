package com.p.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {
	@Value("${A.name}")
	private String name;
	@Value("${A.age}")
	private Integer age;
	
	@RequestMapping("A")
	public String A() {
		return "名字："+name+"年龄："+age;
		
	}
}
