package com.kfarmstar.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.dto.Basket;
import com.kfarmstar.user.mapper.UserPaymentMapper;

@Service
@Transactional
public class UserPaymentService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private UserPaymentMapper userPaymentMapper;
	
	@Autowired
	public UserPaymentService(UserPaymentMapper userPaymentMapper) {
		this.userPaymentMapper = userPaymentMapper;
	}
	
	public List<Basket> basketPurchaseInfoById(String memberId) {
		
		
		return userPaymentMapper.basketPurchaseInfoById(memberId);
	}
	
}
