package com.kfarmstar.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Basket;
import com.kfarmstar.dto.Goods;

@Mapper
public interface UserPaymentMapper {
	
	//상품코드별 결제전 정보 내용 조회
	public Goods beforePaymentInfoByCode(String memberId, String goodsRefurbCode);
	
	//아이디별 장바구니 상품 내역 조회
	public List<Basket> basketPurchaseInfoById(String memberId);
}
