package com.loginreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginreg.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
	public Admin findByEmailAndPassword(String email,String password);
}
