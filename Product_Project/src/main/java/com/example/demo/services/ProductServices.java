package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Product;



public interface ProductServices {
	Product createUser(Product product);
	
	List<Product> getAllUsers();
}
