package com.kfarmstar.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfarmstar.admin.service.DonorGoodsService;
import com.kfarmstar.dto.DonorGoods;


@Controller
@RequestMapping("/donations")
public class DonorController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DonorController.class);

	private DonorGoodsService donorGoodsService;
	
	public DonorController(DonorGoodsService donorGoodsService) {
		this.donorGoodsService = donorGoodsService;
	}

	
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
	public String getDonorGoodsList(Model model) {
		log.info("donorGoodsList DonorController.java 실행1");
		List<DonorGoods> donorGoodsList = donorGoodsService.getDonorGoodsList();
		log.info("donorGoodsList DonorController.java : ", donorGoodsList);
		System.out.println(donorGoodsList.get(0).getDonationBoardCode() + "<- donorGoodsList.get(0).getdonationBoardCode() DonorController.java");
		System.out.println(donorGoodsList.get(0).getGoodsDonationName() + "<- donorGoodsList.get(0).getGoodsDonationName() DonorController.java");
		
		model.addAttribute("title", "FoodRefurb : 기부 상품 목록");
		model.addAttribute("titleName", "기부 상품  목록");
		model.addAttribute("donorGoodsList", donorGoodsList);
		
		return "donations/donorGoodsList";
	}
}
