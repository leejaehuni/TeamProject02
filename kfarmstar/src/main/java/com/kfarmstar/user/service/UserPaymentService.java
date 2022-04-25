package com.kfarmstar.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.dto.AfterPayment;
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
	
	// 결제한 결제 정보 조회
	public List<AfterPayment> afterPaymentInfoByCode(String sessionId, String paymentCompleteCode){
		
		
		return userPaymentMapper.afterPaymentInfoByCode(sessionId, paymentCompleteCode);
	}
	
	// 결제 정보 등록
	public Map<String, Object> addBeforePayment(BeforePayment beforePayment, String sessionId, PaymentType paymentType, String goodsRefurbCode) {
		
		String newCode = commonMapper.getNewCode("purchaser_payment_code", "before_purchaser_info");
		String newCode2 = commonMapper.getNewCode("before_mid_sum_code", "before_purchaser_info");
		String newCode3 = commonMapper.getNewCode("payment_type_code", "type_payment_info");
		String newCode4 = commonMapper.getNewCode("payment_complete_code", "after_payment_info");
		
		beforePayment.setPurchaserPaymentCode(newCode);
		beforePayment.setBeforeMidSumCode(newCode2);
		beforePayment.setMemberId(sessionId);
		beforePayment.setGoodsRefurbCode(goodsRefurbCode);
		
		paymentType.setMemberId(sessionId);
		paymentType.setPaymentTypeCode(newCode3);
		
		AfterPayment afterPayment = new AfterPayment();
		afterPayment.setPaymentCompleteCode(newCode4);
		afterPayment.setPurchaserPaymentCode(newCode);
		afterPayment.setGoodsRefurbCode(goodsRefurbCode);
		afterPayment.setMemberId(sessionId);
		afterPayment.setPaymentTypeCode(newCode3);
		afterPayment.setBeforeGoodsCount(beforePayment.getBeforeGoodsCount());
		afterPayment.setMidSumPrice(beforePayment.getMidSumPrice());
		afterPayment.setPaymentOption(paymentType.getPaymentOptionType());
		afterPayment.setLastPaymentPrice(beforePayment.getMidSumPrice());
		
		
		int result = userPaymentMapper.addBeforePayment(beforePayment);
		result += userPaymentMapper.addPaymentType(paymentType);
		result += userPaymentMapper.addAfterPayment(afterPayment);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("paymentCompleteCode", afterPayment.getPaymentCompleteCode());
		
		return resultMap;
	}
	
	// 상품코드별 상품 정보 조회
	public List<Goods> beforePaymentInfoByCode(String sessionId, String goodsRefurbCode) {
		
		return userPaymentMapper.beforePaymentInfoByCode(sessionId, goodsRefurbCode); 
	}
	
	public List<Basket> basketPurchaseInfoById(String memberId) {
		
		return userPaymentMapper.basketPurchaseInfoById(memberId);
	}
	
}
