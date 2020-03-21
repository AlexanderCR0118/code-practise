package com.p.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:/properties/B.properties")
public class BController {
	@Value("${B.name}")
	private String name;
	@Value("${B.id}")
	private Integer id;
	@RequestMapping("B")
	public String B() {
		return "名字："+name+"编号："+id;
		
	}
}
