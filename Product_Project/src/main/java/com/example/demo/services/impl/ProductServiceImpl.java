package com.example.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductServices;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServices{
	
	private ProductRepository productRepository;
	@Override
	public Product createUser(Product user) {
		return productRepository.save(user);
	}
	
	@Override
	public List<Product> getAllUsers(){
		return productRepository.findAll();
	}
}
