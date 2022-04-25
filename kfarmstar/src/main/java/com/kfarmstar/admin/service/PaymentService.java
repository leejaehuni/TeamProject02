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
/*깃허브수정*/
@Service
@Transactional
public class PaymentService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private PaymentMapper paymentMapper;
	
	@Autowired
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	// 날짜별 환불내역 목록 조회
	public List<GoodsRefund> searchDateGoodsRefund(String startDate, String endDate){
		
		List<GoodsRefund> searchDateGoodsRefund = paymentMapper.searchDateGoodsRefund(startDate, endDate);
		
		return searchDateGoodsRefund;
	}
	
	// 처리상태별 상품교환내역 목록 조회
	public List<GoodsExchange> searchStateExchange(String exchangeProcessState){
		
		List<GoodsExchange> searchStateExchange = paymentMapper.searchStateExchange(exchangeProcessState);
		
		return searchStateExchange;
	}
	
	// 날짜별 상품교환내역 목록 조회
	public List<GoodsExchange> searchDateGoodsExchange(String startDate, String endDate){
		
		List<GoodsExchange> searchDateGoodsExchange = paymentMapper.searchDateGoodsExchange(startDate, endDate);
		
		return searchDateGoodsExchange;
	}
	
	// 결제수단별 결제내역 목록 조회
	public List<AfterPayment> searchTypeAfterPayment(String paymentOption){
		
		List<AfterPayment> searchTypeAfterPayment = paymentMapper.searchTypeAfterPayment(paymentOption);
		
		return searchTypeAfterPayment;
	}
	
	// 날짜별 주문취소내역 목록 조회
	public List<OrderCancel> searchDateOrderCancel(String startDate, String endDate){
		
		List<OrderCancel> searchDateOrderCancel = paymentMapper.searchDateOrderCancel(startDate, endDate);
		
		return searchDateOrderCancel;
	}
	
	// 결제시각별 결제내역 목록 조회
	public List<AfterPayment> searchDateAfterPayment(String startDate, String endDate){
		
		List<AfterPayment> searchDateAfterPayment = paymentMapper.searchDateAfterPayment(startDate, endDate);
		
		return searchDateAfterPayment;
	}
	
	public List<GoodsRefund> conditionGoodsRefundList(String searchKey, String searchValue){
		
		List<GoodsRefund> conditionGoodsRefundList = paymentMapper.conditionGoodsRefundList(searchKey, searchValue);
		
		return conditionGoodsRefundList;
	}
	
	// 검색조건별 상품  교환 내역 목록 조회
	public List<GoodsExchange> conditionGoodsExchangeList(String searchKey, String searchValue){
		
		List<GoodsExchange> conditionGoodsExchangeList = paymentMapper.conditionGoodsExchangeList(searchKey, searchValue);
		
		return conditionGoodsExchangeList;
		
	}
	
	// 검색조건별 주문취소내역 조회
	public List<OrderCancel> conditionOrderCancelList(String searchKey, String searchValue){
		
		List<OrderCancel> conditionOrderCancelList = paymentMapper.conditionOrderCancelList(searchKey, searchValue);
		
		return conditionOrderCancelList;
	}
	
	// 상품 환불 상세내역 수정
	public int modifyGoodsRefund(GoodsRefund goodsRefund) {
		
		return paymentMapper.modifyGoodsRefund(goodsRefund);
	}
	
	// 주문취소상세내역 수정
	public int modifyOrderCancel(OrderCancel orderCancel) {
		
		return paymentMapper.modifyOrderCancel(orderCancel);
	}
	
	// 상품 교환 내역 정보 수정
	public int modifyGoodsExchange(GoodsExchange goodsExchange) {
		
		return paymentMapper.modifyGoodsExchange(goodsExchange);
	}
	
	// 상품 환불 상세 내역 조회
	public GoodsRefund goodsRefundInfoByCode(String refundCode) {
		
		return paymentMapper.goodsRefundInfoByCode(refundCode);
	}
	
	// 결제 환불 내역 조회
	public List<GoodsRefund> goodsRefundInfo(String searchKey, String searchValue){
		
		List<GoodsRefund> goodsRefundInfo = paymentMapper.goodsRefundInfo(searchKey, searchValue);
		
		return goodsRefundInfo;
	}
	
	// 상품 교환 상세 내역 조회
	public GoodsExchange goodsExchangeInfoByCode(String goodsExchangeCode) {
		
		return paymentMapper.goodsExchangeInfoByCode(goodsExchangeCode);
	}
	
	//결제수단별 결제 내역 목록 조회
	public List<AfterPayment> conditionAfterPaymentList(String searchKey, String searchValue) {
		
		List<AfterPayment> conditionAfterPaymentList = paymentMapper.conditionAfterPaymentList(searchKey, searchValue);
		
		return conditionAfterPaymentList;
	}
	
	//상품교환 내역 목록 조회
	public List<GoodsExchange> goodsExchangeInfo(String searchKey, String searchValue) {
		
		List<GoodsExchange> goodsExchangeInfo = paymentMapper.goodsExchangeInfo(searchKey, searchValue);
		
		return goodsExchangeInfo;
	}
	
	//주문취소코드별 주문 상세 내역 조회
	public OrderCancel orderCancelInfoByCode(String orderCancelCode) {
		
		return paymentMapper.orderCancelInfoByCode(orderCancelCode);
	}
	
	// 구매자가 결제한 결제 내역 목록 조회
	public List<AfterPayment> afterPaymentInfo(String searchKey, String searchValue){
		
		List<AfterPayment> afterPaymentInfo = paymentMapper.afterPaymentInfo(searchKey, searchValue);
		
		return afterPaymentInfo;
	}
	
	// 결제코드별 결제상세내역 조회
	public AfterPayment afterPaymentInfoByCode(String paymentCompleteCode) {
		
		return paymentMapper.afterPaymentInfoByCode(paymentCompleteCode);
	}
	
	// 주문취소내역 목록 조회
	public List<OrderCancel> orderCancelInfo(String searchKey, String searchValue){
		
		List<OrderCancel> orderCancelInfo = paymentMapper.orderCancelInfo(searchKey, searchValue);
		
		return orderCancelInfo;
	}
	
}
