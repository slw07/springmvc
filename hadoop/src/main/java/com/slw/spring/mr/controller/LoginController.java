package com.slw.spring.mr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slw.spring.mr.entity.User;
import com.slw.spring.mr.service.LoginService;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "getUsers",method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers(){
		return loginService.getUsers();
	}
	
	@RequestMapping(value = "operation",method = RequestMethod.GET)
	@Transactional
	public void operation(){
		User user = new User();
		user.setId("1111");
		user.setUserId("34");
		user.setName("33");
		loginService.updateUser(user);
		loginService.insertUser(user);
	}
}
