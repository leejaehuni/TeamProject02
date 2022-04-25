package com.kfarmstar.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kfarmstar.dto.Goods;
import com.kfarmstar.user.service.UserGoodsService;

@Controller
public class UserMainController {
	
	
	private UserGoodsService userGoodsService;
		
		public UserMainController(UserGoodsService userGoodsService) {
			this.userGoodsService = userGoodsService;
		}
	
		
	/*
	 * 작성자 : 이지수
	 * 작성일자 : 22-04-15
	 * 사용자 화면 - 최신 상품 8개 조회
	 */
	@GetMapping("/userMain")
	public String main(Model model) {
		
		List<Goods> userMainGoodsList = userGoodsService.getUserMainGoodsList();
		model.addAttribute("title", "Food Refurb");
		model.addAttribute("userMainGoodsList", userMainGoodsList);
		
		return "userMain";
	}
	
}
