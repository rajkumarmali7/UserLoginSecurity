package com.UserloginSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserloginSecurity.dto.Logindto;
import com.UserloginSecurity.dto.Userdto;
import com.UserloginSecurity.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/signUp")
	public Userdto userSignUp(@RequestBody Userdto userdto)
	{
		userservice.signUp(userdto);
		return userdto;
	}
	
	@PostMapping("/login")
	public String userlogin(@RequestBody Logindto logindto)
	{
		String str= this.userservice.login(logindto);
		return str;
	}
	
	@GetMapping("/featch")
	public List<Userdto> userfeatch()
	{
		List<Userdto> UserList = userservice.featchAllData();
		return UserList;
	}
	
}
