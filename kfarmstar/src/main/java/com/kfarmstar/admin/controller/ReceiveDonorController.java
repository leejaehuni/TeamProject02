package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donations")
public class ReceiveDonorController {
	
	/**
	 * 기부 상품 수령 신청 삭제
	 */
	@GetMapping("/removeDonorApply")
	public String removeDonorApply(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 수령 신청 삭제");
		model.addAttribute("titleName", "기부 상품 수령 신청 삭제");
		
		return "donations/removeDonorApply";
	}
	
	/**
	 * 기부 상품 수령 신청 수정
	 */
	@GetMapping("/modifyDonorApply")
	public String modifyDonorApply(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 수령 신청 수정");
		model.addAttribute("titleName", "기부 상품 수령 신청 수정");
		
		return "donations/modifyDonorApply";
	}
	
	/**
	 * 기부 상품 수령 신청 등록
	 */
	@GetMapping("/donorGoodsApply")
	public String donorGoodsApply(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 수령 신청 등록");
		model.addAttribute("titleName", "기부 상품 수령 신청 등록");
		
		return "donations/donorGoodsApply";
	}
	
	/**
	 * 기부 상품 수령 신청 목록
	 */
	@GetMapping("/donorApplyList")
	public String getdonorApplyList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 수령 신청 목록");
		model.addAttribute("titleName", "기부 상품 수령 신청 목록");
		
		return "donations/donorApplyList";
	}
}
