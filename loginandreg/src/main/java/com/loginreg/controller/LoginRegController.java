package com.loginreg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginreg.ResourceNotFoundException;

import com.loginreg.model.User;
import com.loginreg.repository.LoginRegRepository;
import com.loginreg.service.LoginRegService;

@RestController
public class LoginRegController {

	@Autowired
	private LoginRegService service;
	@Autowired
	private LoginRegRepository repo;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmail=user.getEmail();
		if(tempEmail!= null && !"".equals(tempEmail))
		{
			User userObj=service.fetchUserByEmail(tempEmail);
			if(userObj !=null)
				throw new Exception("User with "+tempEmail+"is already exist");
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmail=user.getEmail();
		String tempPass= user.getPassword();
		User userObj=null;
		if(tempEmail!=null && tempPass!=null)
		{
			userObj=service.fetchUserByEmailAndPassword(tempEmail, tempPass);
		
		}
		if(userObj==null)
		{
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/users")
	public List<User> getusers() {
		return repo.findAll();

	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)

	public User getUser(@PathVariable("id") int id) {

		return repo.findById(id).get();

	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		repo.deleteById(id);

	}

}