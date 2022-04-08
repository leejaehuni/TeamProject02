package com.kfarmstar.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfarmstar.user.mapper.UserPaymentMapper;
import com.kfarmstar.user.service.UserPaymentService;

@Controller
@RequestMapping("/userPayment")
public class UserPaymentController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserPaymentController.class);

	private UserPaymentService userPaymentService;
	private UserPaymentMapper userPaymemtMapper;
	
	public UserPaymentController(UserPaymentService userPaymentService, UserPaymentMapper userPaymemtMapper) {
		this.userPaymentService = userPaymentService;
		this.userPaymemtMapper = userPaymemtMapper;
	}
	
	@GetMapping("/basketPurchase")
	public String basketPurchase(Model model) {
		
		model.addAttribute("title", "Food Refurb : 장바구니");
		model.addAttribute("breadTitle", "Shopping Cart");
		model.addAttribute("breadSubTitle", "Shopping Cart");
		
		
		return "userPayment/basketPurchase";
	}
	
}
