package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donations")
public class DonorPlaceController {
	
	/**
	 * 기부 상품 사용처 삭제
	 */
	@GetMapping("/removeDonorPlace")
	public String removeDonorPlace(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 사용처 삭제");
		model.addAttribute("titleName", "기부 상품 사용처 삭제");
		
		return "donations/removeDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 수정
	 */
	@GetMapping("/modifyDonorPlace")
	public String modifyDonorPlace(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 사용처 수정");
		model.addAttribute("titleName", "기부 사용처 수정");
		
		return "donations/modifyDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 등록 심사
	 */
	@GetMapping("/confirmDonorPlace")
	public String confirmDonorPlace(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 사용처 등록 심사");
		model.addAttribute("titleName", "기부 사용처 등록 심사");
		
		return "donations/confirmDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 등록 신청
	 */
	@GetMapping("/applyDonorPlace")
	public String applyDonorPlace(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 사용처 등록 신청");
		model.addAttribute("titleName", "기부 사용처 등록 신청");
		
		return "donations/applyDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 등록
	 */
	@GetMapping("/addDonorPlace")
	public String addDonorPlace(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 사용처 등록");
		model.addAttribute("titleName", "기부 사용처 등록");
		
		return "donations/addDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 목록
	 */
	@GetMapping("/donorPlaceList")
	public String getdonorPlaceList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 사용처 목록");
		model.addAttribute("titleName", "기부 사용처 목록");
		
		return "donations/donorPlaceList";
	}
}
