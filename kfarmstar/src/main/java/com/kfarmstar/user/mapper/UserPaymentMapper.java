package com.kfarmstar.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Basket;

@Mapper
public interface UserPaymentMapper {
	
	//아이디별 장바구니 상품 내역 조회
	public List<Basket> basketPurchaseInfoById(String memberId);
}
