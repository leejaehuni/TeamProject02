package com.kfarmstar.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.admin.mapper.PaymentMapper;
import com.kfarmstar.admin.service.MemberService;
import com.kfarmstar.admin.service.PaymentService;
import com.kfarmstar.dto.AfterPayment;
import com.kfarmstar.dto.GoodsExchange;
import com.kfarmstar.dto.GoodsRefund;
import com.kfarmstar.dto.OrderCancel;


@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private PaymentService paymentService;
	private PaymentMapper paymentMapper;
	
	public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
		this.paymentService = paymentService;
		this.paymentMapper = paymentMapper;
	}
	
	@GetMapping("/basketPurchaseList")
	public String basketPurchaseList(Model model) {
		return "payment/basketPurchaseList";
	}
	
	@GetMapping("/beforePurchaserInfo")
	public String beforePurchaserInfo(Model model) {
		return "payment/beforePurchaserInfo";
	}
	
	@GetMapping("/conditionAfterPaymentList")
	public String conditionAfterPaymentList(Model model
											,@RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("조건별 결제 내역 검색:{}", searchValue);
		
		List<AfterPayment> conditionAfterPaymentList = paymentService.conditionAfterPaymentList(searchKey, searchValue);
		
		model.addAttribute("afterPaymentInfo", conditionAfterPaymentList);
		
		return "payment/afterPaymentInfo";
	}
	
	@GetMapping("/afterPaymentInfo")
	public String afterPaymentInfo(Model model
									,@RequestParam(value="searchKey", required = false) String searchKey
									,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		List<AfterPayment> afterPaymentInfo = paymentService.afterPaymentInfo(searchKey, searchValue);
		
		model.addAttribute("title", "FoodRefurb : 결제관리");
		model.addAttribute("titleName", "결제 내역 관리");
		model.addAttribute("afterPaymentInfo", afterPaymentInfo);
		
		return "payment/afterPaymentInfo";
	}
	
	@GetMapping("/afterPaymentDetail")
	public String afterPaymentDetail(Model model
									,@RequestParam(name="paymentCompleteCode", required = false) String paymentCompleteCode) {
		
		AfterPayment afterPayment = paymentService.afterPaymentInfoByCode(paymentCompleteCode);
		
		log.info("결제상세내역:{}", paymentCompleteCode);
		
		model.addAttribute("title", "FoodRefurb : 결제 정보");
		model.addAttribute("titleName", "결제 상세 정보");
		model.addAttribute("afterPayment", afterPayment);
		
		return "payment/afterPaymentDetail";
	}
	
	@GetMapping("/afterPaymentModify")
	public String afterPaymentModify(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 결제수정");
		model.addAttribute("titleName", "결제 내역 수정");
		
		return "payment/afterPaymentModify";
	}
	
	@GetMapping("/afterPaymentRemove")
	public String afterPaymentRemove(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 결제삭제");
		model.addAttribute("titleName", "결제 내역 삭제");
		
		return "payment/afterPaymentRemove";
	}
	
	@GetMapping("/afterPaymentStatistics")
	public String afterPaymentStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 결제통계");
		model.addAttribute("titleName", "결제 내역 통계");
		
		return "payment/afterPaymentStatistics";
	}
	
	@GetMapping("/goodsOrderCancel")
	public String goodsOrderCancel(Model model
									,@RequestParam(value="searchKey", required = false) String searchKey
									,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("주문취소내역:{}", searchValue);
		
		List<OrderCancel> orderCancelInfo = paymentService.orderCancelInfo(searchKey, searchValue);
		
		model.addAttribute("title", "FoodRefurb : 주문취소관리");
		model.addAttribute("titleName", "주문 취소 내역 관리");
		model.addAttribute("orderCancelInfo", orderCancelInfo);
		
		return "payment/goodsOrderCancel";
	}
	
	@GetMapping("/goodsOrderCancelDetail")
	public String goodsOrderCancelDetail(Model model
										,@RequestParam(name="orderCancelCode", required = false) String orderCancelCode) {
		
		log.info("주문취소내역:{}", orderCancelCode);
		
		OrderCancel orderCancel = paymentService.orderCancelInfoByCode(orderCancelCode);
		
		model.addAttribute("title", "FoodRefurb : 주문 취소 정보");
		model.addAttribute("titleName", "주문 취소 정보");
		model.addAttribute("orderCancel", orderCancel);
		
		return "payment/goodsOrderCancelDetail";
	}
	
	@GetMapping("/goodsOrderCancelModify")
	public String goodsOrderCancelModify(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 주문취소수정");
		model.addAttribute("titleName", "주문 취소 내역 수정");
		
		return "payment/goodsOrderCancelModify";
	}
	
	@GetMapping("/goodsOrderCancelRemove")
	public String goodsOrderCancelRemove(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 주문취소삭제");
		model.addAttribute("titleName", "주문 취소 내역 삭제");
		
		return "payment/goodsOrderCancelRemove";
	}
	
	@GetMapping("/goodsOrderStatistics")
	public String goodsOrderStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 주문취소통계");
		model.addAttribute("titleName", "주문 취소 내역 통계");
		
		return "payment/goodsOrderStatistics";
	}
	
	@GetMapping("/goodsExchange")
	public String goodsExchange(Model model
								,@RequestParam(value="searchKey", required = false) String searchKey
								,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("상품교환내역:{}", searchValue);
		
		List<GoodsExchange> goodsExchangeInfo = paymentService.goodsExchangeInfo(searchKey, searchValue);
		
		model.addAttribute("title", "FoodRefurb : 상품교환관리");
		model.addAttribute("titleName", "상품 교환 내역 관리");
		model.addAttribute("goodsExchangeInfo", goodsExchangeInfo);
		
		return "payment/goodsExchange";
	}
	
	@GetMapping("/goodsExchangeModify")
	public String goodsExchangeModify(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품교환수정");
		model.addAttribute("titleName", "상품 교환 내역 수정");
		
		return "payment/goodsExchangeModify";
	}
	
	@GetMapping("/goodsExchangeRemove")
	public String goodsExchangeRemove(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품교환삭제");
		model.addAttribute("titleName", "상품 교환 내역 삭제");
		
		return "payment/goodsExchangeRemove";
	}
	
	@GetMapping("/goodsExchangeDetail")
	public String goodsExchangeDetail(Model model
									,@RequestParam(name="goodsExchangeCode", required = false) String goodsExchangeCode) {
		
		log.info("상품교환상세내역:{}", goodsExchangeCode);
		
		GoodsExchange goodsExchange = paymentService.goodsExchangeInfoByCode(goodsExchangeCode);
		
		model.addAttribute("title", "FoodRefurb : 상품 교환 정보");
		model.addAttribute("titleName", "상품 교환 정보");
		model.addAttribute("goodsExchange", goodsExchange);
		
		return "payment/goodsExchangeDetail";
	}
	
	@GetMapping("/goodsRefund")
	public String goodsRefund(Model model
								,@RequestParam(value="searchKey", required = false) String searchKey
								,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("상품환불내역:{}", searchValue);
		
		List<GoodsRefund> goodsRefundInfo = paymentService.goodsRefundInfo(searchKey, searchValue);
		
		
		model.addAttribute("title", "FoodRefurb : 환불관리");
		model.addAttribute("titleName", "상품 환불 내역 관리");
		model.addAttribute("goodsRefundInfo", goodsRefundInfo);
		
		return "payment/goodsRefund";
	}
	
	@GetMapping("/goodsRefundModify")
	public String goodsRefundModify(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 환불수정");
		model.addAttribute("titleName", "환불 내역 수정");
		
		return "payment/goodsRefundModify";
	}
	
	@GetMapping("/goodsRefundRemove")
	public String goodsRefundRemove(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 환불삭제");
		model.addAttribute("titleName", "환불 내역 삭제");
		
		return "payment/goodsRefundRemove";
	}
	
	@GetMapping("/goodsRefundDetail")
	public String goodsRefundDetail(Model model
									,@RequestParam(name="refundCode", required = false) String refundCode) {
		
		log.info("상품환불상세내역:{}", refundCode);
		
		GoodsRefund goodsRefund = paymentService.goodsRefundInfoByCode(refundCode);
		
		model.addAttribute("title", "FoodRefurb : 상품 환불 정보");
		model.addAttribute("titleName", "상품 환불 정보");
		model.addAttribute("goodsRefund", goodsRefund);
		
		return "payment/goodsRefundDetail";
	}
	
	@GetMapping("/goodsRefundStatistics")
	public String goodsRefundStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 환불통계");
		model.addAttribute("titleName", "상품 환불 내역 통계");
		
		return "payment/goodsRefundStatistics";
	}
}
