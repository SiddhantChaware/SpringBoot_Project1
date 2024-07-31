package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CartItem;
import com.example.demo.services.CartService;

@RestController
@RequestMapping("api/cart")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping
	public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem){
		CartItem savedCartItem = cartService.addCartItem(cartItem);
		return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
	}
}
