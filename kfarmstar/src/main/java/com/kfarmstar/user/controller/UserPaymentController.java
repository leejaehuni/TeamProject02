package com.kfarmstar.user.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kfarmstar.dto.AfterPayment;
import com.kfarmstar.dto.Basket;
import com.kfarmstar.dto.BeforePayment;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.PaymentType;
import com.kfarmstar.user.mapper.UserPaymentMapper;
import com.kfarmstar.user.service.UserPaymentService;
/*깃허브수정*/
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
	
	@GetMapping("/userAfterPayment")
	public String userAfterPayment(Model model
									,HttpSession session
									,@RequestParam(value="goodsRefurbCode", required = false) String goodsRefurbCode
									,@RequestParam(value="paymentCompleteCode", required = false) String paymentCompleteCode
									,BeforePayment beforePayment) {
		
		String sessionId = (String) session.getAttribute("SID");
		log.info("상품코드:{}", goodsRefurbCode);
		List<AfterPayment> userAfterPayment = userPaymentService.afterPaymentInfoByCode(sessionId, paymentCompleteCode);
		
		
		model.addAttribute("title", "Food Refurb : 결제정보");
		model.addAttribute("breadTitle", "Payment Info");
		model.addAttribute("breadSubTitle", "Payment Info");
		model.addAttribute("userAfterPayment", userAfterPayment.get(0));
		model.addAttribute("beforePayment", beforePayment);
		
		return "userPayment/userAfterPayment";
	}
	
	
	@PostMapping("/userBeforePayment")
	public String userBeforePayment(HttpSession session
									,BeforePayment beforePayment
									,@RequestParam(value="goodsRefurbCode", required = false) String goodsRefurbCode
									,PaymentType paymentType
									,RedirectAttributes reAttr) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		 Map<String, Object> resultMap = userPaymentService.addBeforePayment(beforePayment, sessionId, paymentType, goodsRefurbCode);
		
		 
		 log.info("결제전 정보 기입:{}", beforePayment);
		 log.info("결제전 아이디 값 가져오기:{}", sessionId);
		 log.info("상품코드가져오나요:{}", goodsRefurbCode);
		 reAttr.addAttribute("goodsRefurbCode", goodsRefurbCode);
		 reAttr.addAttribute("paymentCompleteCode", (String) resultMap.get("paymentCompleteCode"));
		 
		 return "redirect:/userPayment/userAfterPayment";
	}
	
	@GetMapping("/userBeforePayment")
	public String userBeforePayment(Model model
									,HttpSession session
									,@RequestParam(value="goodsCount") String goodsCount
									,@RequestParam(value="goodsRefurbCode", required = false) String goodsRefurbCode
									,Goods goods) {
		
		String sessionId = (String) session.getAttribute("SID");
		List<Goods> goodsList = userPaymentService.beforePaymentInfoByCode(sessionId, goodsRefurbCode);
		log.info("수량 코드 확인" + goodsCount);
		int totalPrice = Integer.valueOf(goodsCount)*Integer.valueOf(goods.getGoodsRefurbPrice());
		
		
		  NumberFormat numberFormat = NumberFormat.getInstance(); 
		  int refurbPrice = Integer.parseInt(goods.getGoodsRefurbPrice()); 
		  
		  String refurbResult = numberFormat.format(refurbPrice); 
		  String totalPriceResult = numberFormat.format(totalPrice);
		  

		 
		
		model.addAttribute("title", "Food Refurb : 개인 상품");	
		model.addAttribute("breadTitle", "Refurb Goods");
		model.addAttribute("breadSubTitle", "Goods Info");
		model.addAttribute("refurbResult", refurbPrice);
		model.addAttribute("totalPriceResult", totalPrice);
		
		
		model.addAttribute("title", "Food Refurb : 결제화면");
		model.addAttribute("breadTitle", "Checkout");
		model.addAttribute("breadSubTitle", "Checkout");
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCount", goodsCount);
		model.addAttribute("goods", goods);
		
		
		return "userPayment/userBeforePayment";
	}
	
	
	@GetMapping("/basketPurchase")
	public String basketPurchase(Model model
								,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		
		
		model.addAttribute("title", "Food Refurb : 장바구니");
		model.addAttribute("breadTitle", "Shopping Cart");
		model.addAttribute("breadSubTitle", "Shopping Cart");
		
		
		return "userPayment/basketPurchase";
	}
	
}
