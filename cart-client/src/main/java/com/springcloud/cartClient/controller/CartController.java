package com.springcloud.cartClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.cartClient.services.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/")
	public String getCartDetails() {
		return "Cart service returned -->"+cartService.getCart().toString();
	}
}
