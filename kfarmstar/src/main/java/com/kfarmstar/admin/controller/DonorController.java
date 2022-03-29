package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donations")
public class DonorController {
	
	/**
	 * 기부 상품 삭제 
	 */
	@GetMapping("/removeDonorGoods")
	public String removeDonorGoods(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 삭제");
		model.addAttribute("titleName", "기부 상품  삭제");
		
		return "donations/removeDonorGoods";
	}
	
	/**
	 * 기부 상품 수정
	 */
	@GetMapping("/modifyDonorGoods")
	public String modifyDonorGoods(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 수정");
		model.addAttribute("titleName", "기부 상품  수정");
		
		return "donations/modifyDonorGoods";
	}
	
	/**
	 * 기부 상품 등록  
	 */
	@GetMapping("/addDonorGoods")
	public String addDonorGoods(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 등록");
		model.addAttribute("titleName", "기부 상품  등록");
		
		return "donations/addDonorGoods";
	}
	
	/**
	 * 기부 상품 목록  
	 */
	@GetMapping("/donorGoodsList")
	public String getdonorGoodsList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 목록");
		model.addAttribute("titleName", "기부 상품  목록");
		
		return "donations/donorGoodsList";
	}
}
