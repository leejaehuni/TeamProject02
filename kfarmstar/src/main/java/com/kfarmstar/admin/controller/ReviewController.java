package com.kfarmstar.admin.controller;

import java.util.HashMap;
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

import com.kfarmstar.admin.service.ReviewService;
import com.kfarmstar.dto.Review;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	/**
	 * 상품평 별점
	 */
	@GetMapping("/starRatingReview")
	public String starRatingReview(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 별점 등록");
		model.addAttribute("titleName", "별점 등록");
		
		return "review/starRatingReview";
	}
	
	/**
	 * 상품평 삭제
	 */
	@GetMapping("/removeReview")
	public String removeReview(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품평 삭제");
		model.addAttribute("titleName", "상품평 삭제");
		
		return "review/removeReview";
	}
	
	
	/**
	 * 상품평 수정
	 */
	@GetMapping("/modifyReview")
	public String modifyReview(Model model
								,@RequestParam(name="reviewNum", required = false) String reviewNum
								,@RequestParam(name="memberId", required = false) String memberId) {
		log.info("회원 수정화면 폼 쿼리스트링 reviewNum : {}", reviewNum);
		log.info("회원 수정화면 폼 쿼리스트링 memberId : {}", memberId);
		
		model.addAttribute("title", "FoodRefurb : 상품평 수정");
		model.addAttribute("titleName", "상품평 수정");
		
		return "review/modifyReview";
	}
	
	/**
	 * 상품평 등록
	 */
	@GetMapping("/addReview")
	public String addReview(Review review
			,HttpSession session
			,@RequestParam(name = "reviewContents" , required = false) String reviewContents
			,@RequestParam(name = "paymentCompleteCode" , required = false) String paymentCompleteCode) {
		log.info("상품평 등록  review{}" , review);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("paymentCompleteCode", paymentCompleteCode);
		log.info("reviewAdminList ReviewController.java : ", paramMap);
		
		return "review/addReview";
	}
	/**
	 * 등록 처리 
	 */
	@PostMapping("/addReview")
	public String addReview(Review review) {
		log.info("addReview ReviewController.java 실행");
		
		reviewService.addReview(review);
	
		return "redirect:/review/reviewList";
	}
	
	
	/**
	 * 상품평 목록
	 */
	@GetMapping("/reviewList")
	public String reviewList(Model model
			 				,@RequestParam(name = "paymentCompleteCode" , required = false)String paymentCompleteCode
			 				,@RequestParam(name = "reviewScoreCode" , required = false)String reviewScoreCode
			 				,@RequestParam(name = "goodsRefurbCode" , required = false)String goodsRefurbCode
							,@RequestParam(name = "memberId" , required = false)String memberId) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("paymentCompleteCode", paymentCompleteCode);
		
		List<Review> reviewList = reviewService.getReviewList(paramMap);
		
		model.addAttribute("title", "FoodRefurb : 상품평 조회");
		model.addAttribute("reviewList", reviewList);
		
		return "review/reviewList";
	}
	/**
	 * 관리자 상품평 목록
	 */
	@GetMapping("/reviewAdminList")
	public String getReviewAdminList(Model model) {
		log.info("reviewAdminList ReviewController.java 실행");
		List<Review> reviewAdminList = reviewService.getReviewAdminList();
		log.info("reviewAdminList ReviewController.java : ", reviewAdminList);
		System.out.println(reviewAdminList.get(0).getReviewNum() + "<- reviewAdminList.get(0).getReviewNum() ReviewController.java");
		System.out.println(reviewAdminList.get(0).getGoodsRefurbCode() + "<- reviewAdminList.get(0).getGoodsRefurbCode() ReviewController.java");
		
		model.addAttribute("title", "FoodRefurb : 상품평 목록");
		model.addAttribute("titleName", "상품평 목록");
		model.addAttribute("reviewAdminList", reviewAdminList);
		
		return "review/reviewAdminList";
	}
}
