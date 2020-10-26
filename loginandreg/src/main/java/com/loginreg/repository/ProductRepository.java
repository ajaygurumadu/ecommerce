package com.loginreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginreg.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}
