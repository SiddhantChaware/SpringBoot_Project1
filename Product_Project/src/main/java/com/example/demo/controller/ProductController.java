package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/product")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {
	
	private ProductServices productService;
	
	@PostMapping
	public ResponseEntity<Product> createUser(@RequestBody Product product){
		System.out.println("Received User for Creation: " + product);
		Product savedUser = productService.createUser(product);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllUsers(){
		List<Product> users = productService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}
