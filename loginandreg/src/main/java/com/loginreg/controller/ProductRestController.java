package com.loginreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginreg.model.Product;
import com.loginreg.repository.ProductRepository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.util.*;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository repository;
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getproducts() {
		return repository.findAll();

	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)

	public Product getProduct(@PathVariable("id") int id) {

		return repository.findById(id).get();

	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);

	}

}