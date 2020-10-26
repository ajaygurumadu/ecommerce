package com.loginreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginreg.model.Admin;
import com.loginreg.repository.AdminRepository;



@Service
public class AdminService {
	@Autowired
	private AdminRepository repo;
	
	public Admin saveUser(Admin admin)
	{
		return repo.save(admin);
	}
	
	public Admin fetchUserByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	public Admin fetchUserByEmailAndPassword(String email,String password)
	{
		return repo.findByEmailAndPassword(email, password);
	}
}
