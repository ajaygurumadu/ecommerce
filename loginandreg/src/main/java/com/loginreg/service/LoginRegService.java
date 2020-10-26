package com.loginreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginreg.model.User;
import com.loginreg.repository.LoginRegRepository;

@Service
public class LoginRegService {

	@Autowired
	private LoginRegRepository repo;
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User fetchUserByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String passwords)
	{
		return repo.findByEmailAndPassword(email, passwords);
	}
}
