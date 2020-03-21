package com.jt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jt.pojo.User;
import com.jt.service.DubboUserService;
import com.jt.util.IPUtil;
import com.jt.vo.SysResult;

/**
 * 完成用户的业务操作
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	//引入中立的接口,创建代理对象,才可以实现RPC调用
	@Reference(check = false)
	private DubboUserService userService;
	
	/**
	 * 实现通用的页面跳转.动态获取页面名称
	 * @param moduleName
	 * @return
	 */
	@RequestMapping("/{moduleName}")
	public String toModule(@PathVariable String moduleName) {
		
		return moduleName;
	}
	
	
	/**
	 * 业务功能:
	 * 	实现用户信息新增.返回系统返回值对象SysResult
	 * @return
	 */
	@RequestMapping("/doRegister")
	@ResponseBody
	public SysResult insertUser(User user) {
		
		userService.insertUser(user);
		return SysResult.success();
	}
	
	/**
	 * 1.准备Cookie对象
	 * 
	 * cookie.setMaxAge(expiry);
	 * expiry>0   为cookie设定超时时间单位秒
	 * expiry=0   删除Cookie
	 * expiry=-1 cookie会话关闭之后删除.
 	 * 
 	 * cookie.setPath("/"); 设定cookie的作用范围
	 * @param user
	 * @return
	 */
	@RequestMapping("/doLogin")
	@ResponseBody
	public SysResult doLogin(User user,HttpServletResponse response,HttpServletRequest request) {
		//获取userIP
		String userIP = IPUtil.getIpAddr(request);
		String ticket = userService.findUserByUP(user,userIP);
		
		//判断数据是否为null
		if(StringUtils.isEmpty(ticket)) {
			
			return SysResult.fail();
		}
		
		//生成的是ticket信息
		Cookie cookie = new Cookie("JT_TICKET", ticket);
		cookie.setMaxAge(7*24*3600); //7天有效
		cookie.setPath("/");         //cookie数据读取的范围
		cookie.setDomain("jt.com");  //设定cookie的共享
		response.addCookie(cookie);
		
		//将username信息保存到cookie中.
		Cookie nameCookie = new Cookie("JT_USER",user.getUsername());
		nameCookie.setMaxAge(7*24*3600); //7天有效
		nameCookie.setPath("/");         //cookie数据读取的范围
		nameCookie.setDomain("jt.com");  //设定cookie的共享
		response.addCookie(nameCookie);
		return SysResult.success(); //正确返回
	}
	
	
	
	
	
	
	
	
	
	
}
