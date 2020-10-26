package com.loginreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginreg.model.User;

public interface LoginRegRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	public User findByEmailAndPassword(String email,String password);
}
