package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.MemberMapper;
import com.kfarmstar.admin.mapper.PaymentMapper;
import com.kfarmstar.dto.AfterPayment;
import com.kfarmstar.dto.GoodsExchange;
import com.kfarmstar.dto.GoodsRefund;
import com.kfarmstar.dto.OrderCancel;

@Service
@Transactional
public class PaymentService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private PaymentMapper paymentMapper;
	
	@Autowired
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	public List<GoodsRefund> conditionGoodsRefundList(String searchKey, String searchValue){
		
		List<GoodsRefund> conditionGoodsRefundList = paymentMapper.conditionGoodsRefundList(searchKey, searchValue);
		
		return conditionGoodsRefundList;
	}
	
	public List<GoodsExchange> conditionGoodsExchangeList(String searchKey, String searchValue){
		
		List<GoodsExchange> conditionGoodsExchangeList = paymentMapper.conditionGoodsExchangeList(searchKey, searchValue);
		
		return conditionGoodsExchangeList;
		
	}
	
	public List<OrderCancel> conditionOrderCancelList(String searchKey, String searchValue){
		
		List<OrderCancel> conditionOrderCancelList = paymentMapper.conditionOrderCancelList(searchKey, searchValue);
		
		return conditionOrderCancelList;
	}
	
	public int modifyGoodsRefund(GoodsRefund goodsRefund) {
		
		return paymentMapper.modifyGoodsRefund(goodsRefund);
	}
	
	public int modifyOrderCancel(OrderCancel orderCancel) {
		
		return paymentMapper.modifyOrderCancel(orderCancel);
	}
	
	public int modifyGoodsExchange(GoodsExchange goodsExchange) {
		
		return paymentMapper.modifyGoodsExchange(goodsExchange);
	}
	
	public GoodsRefund goodsRefundInfoByCode(String refundCode) {
		
		return paymentMapper.goodsRefundInfoByCode(refundCode);
	}
	
	public List<GoodsRefund> goodsRefundInfo(String searchKey, String searchValue){
		
		List<GoodsRefund> goodsRefundInfo = paymentMapper.goodsRefundInfo(searchKey, searchValue);
		
		return goodsRefundInfo;
	}
	
	public GoodsExchange goodsExchangeInfoByCode(String goodsExchangeCode) {
		
		return paymentMapper.goodsExchangeInfoByCode(goodsExchangeCode);
	}
	
	public List<AfterPayment> conditionAfterPaymentList(String searchKey, String searchValue) {
		
		List<AfterPayment> conditionAfterPaymentList = paymentMapper.conditionAfterPaymentList(searchKey, searchValue);
		
		return conditionAfterPaymentList;
	}
	
	public List<GoodsExchange> goodsExchangeInfo(String searchKey, String searchValue) {
		
		List<GoodsExchange> goodsExchangeInfo = paymentMapper.goodsExchangeInfo(searchKey, searchValue);
		
		return goodsExchangeInfo;
	}
	
	public OrderCancel orderCancelInfoByCode(String orderCancelCode) {
		
		return paymentMapper.orderCancelInfoByCode(orderCancelCode);
	}
	
	public List<AfterPayment> afterPaymentInfo(String searchKey, String searchValue){
		
		List<AfterPayment> afterPaymentInfo = paymentMapper.afterPaymentInfo(searchKey, searchValue);
		
		return afterPaymentInfo;
	}
	
	public AfterPayment afterPaymentInfoByCode(String paymentCompleteCode) {
		
		return paymentMapper.afterPaymentInfoByCode(paymentCompleteCode);
	}
	
	public List<OrderCancel> orderCancelInfo(String searchKey, String searchValue){
		
		List<OrderCancel> orderCancelInfo = paymentMapper.orderCancelInfo(searchKey, searchValue);
		
		return orderCancelInfo;
		
	}
	
}
