package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	
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
	public String modifyReview(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품평 수정");
		model.addAttribute("titleName", "상품평 수정");
		
		return "review/modifyReview";
	}
	
	/**
	 * 상품평 등록
	 */
	@GetMapping("/addReview")
	public String addReview(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품평 등록");
		model.addAttribute("titleName", "상품평 등록");
		
		return "review/addReview";
	}
	
	/**
	 * 상품평 목록
	 */
	@GetMapping("/reviewList")
	public String getreviewList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품평 목록");
		model.addAttribute("titleName", "상품평 목록");
		
		return "review/reviewList";
	}
	/**
	 * 관리자 상품평 목록
	 */
	@GetMapping("/reviewAdminList")
	public String reviewAdminList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품평 목록");
		model.addAttribute("titleName", "상품평 목록");
		
		return "review/reviewAdminList";
	}
}
