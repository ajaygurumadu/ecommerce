package com.loginreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginreg.model.Admin;
import com.loginreg.service.AdminService;


@RestController
public class AdminController {

	@Autowired
	private AdminService services;
	
	@PostMapping("/registeradmin")
	@CrossOrigin(origins="http://localhost:4200")
	public Admin registerUser(@RequestBody Admin admin) throws Exception
	{
		String tempEmail=admin.getEmail();
		if(tempEmail!= null && !"".equals(tempEmail))
		{
			Admin adminObj=services.fetchUserByEmail(tempEmail);
			if(adminObj !=null)
				throw new Exception("User with "+tempEmail+"is already exist");
		}
		Admin adminObj=null;
		adminObj=services.saveUser(admin);
		return adminObj;
	}
	
	@PostMapping("/adminlogin")
	@CrossOrigin(origins="http://localhost:4200")
	public Admin loginUser(@RequestBody Admin admin) throws Exception
	{
		String tempEmail=admin.getEmail();
		String tempPass= admin.getPassword();
		Admin adminObj=null;
		if(tempEmail!=null && tempPass!=null)
		{
			adminObj=services.fetchUserByEmailAndPassword(tempEmail, tempPass);
		
		}
		if(adminObj==null)
		{
			throw new Exception("Bad Credentials");
		}
		return adminObj;
	}
}
