package com.kfarmstar.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.AfterPayment;
import com.kfarmstar.dto.Basket;
import com.kfarmstar.dto.BeforePayment;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.PaymentType;
/*깃허브수정*/
@Mapper
public interface UserPaymentMapper {
	
	//결제후 상품 정보 내용 조회
	public List<AfterPayment> afterPaymentInfoByCode(String memberId, String paymentCompleteCode);
	
	//결제전 결제할 타입 기입
	public int addPaymentType(PaymentType paymentType);
	
	//결제전 구매자 정보 기입
	public int addBeforePayment(BeforePayment beforePayment);
	
	//결제후 구매자 정보 기입
	public int addAfterPayment(AfterPayment afterPayment);
	
	//상품코드별 결제전 정보 내용 조회
	public List<Goods> beforePaymentInfoByCode(String memberId, String goodsRefurbCode);
	
	//아이디별 장바구니 상품 내역 조회
	public List<Basket> basketPurchaseInfoById(String memberId);
}
