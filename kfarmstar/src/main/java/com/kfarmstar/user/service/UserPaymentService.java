package com.kfarmstar.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.dto.Basket;
import com.kfarmstar.dto.BeforePayment;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.PaymentType;
import com.kfarmstar.user.mapper.UserPaymentMapper;
/*깃허브수정*/
@Service
@Transactional
public class UserPaymentService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private UserPaymentMapper userPaymentMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public UserPaymentService(UserPaymentMapper userPaymentMapper, CommonMapper commonMapper) {
		this.userPaymentMapper = userPaymentMapper;
		this.commonMapper = commonMapper;
	}
	
	public List<BeforePayment> afterPaymentInfoByCode(String sessionId, String goodsRefurbCode){
		
		
		return userPaymentMapper.afterPaymentInfoByCode(sessionId, goodsRefurbCode);
	}
	
	public int addBeforePayment(BeforePayment beforePayment, String sessionId, PaymentType paymentType, String goodsRefurbCode) {
		
		String newCode = commonMapper.getNewCode("purchaser_payment_code", "before_purchaser_info");
		String newCode2 = commonMapper.getNewCode("before_mid_sum_code", "before_purchaser_info");
		String newCode3 = commonMapper.getNewCode("payment_type_code", "type_payment_info");
		
		beforePayment.setPurchaserPaymentCode(newCode);
		beforePayment.setBeforeMidSumCode(newCode2);
		beforePayment.setMemberId(sessionId);
		beforePayment.setGoodsRefurbCode(goodsRefurbCode);
		
		paymentType.setMemberId(sessionId);
		paymentType.setPaymentTypeCode(newCode3);
		
		int result = userPaymentMapper.addBeforePayment(beforePayment);
		result += userPaymentMapper.addPaymentType(paymentType);
		
		return result;
	}
	
	public List<Goods> beforePaymentInfoByCode(String sessionId, String goodsRefurbCode) {
		
		return userPaymentMapper.beforePaymentInfoByCode(sessionId, goodsRefurbCode); 
	}
	
	public List<Basket> basketPurchaseInfoById(String memberId) {
		
		return userPaymentMapper.basketPurchaseInfoById(memberId);
	}
	
}
