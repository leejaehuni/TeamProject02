package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	@GetMapping("/getLargeStatistics")
	public String getLargeStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 대분류 상품 통계 조회");
		model.addAttribute("titleName", "대분류 상품 통계 조회");
		
		return "statistics/getLargeStatistics";
	}
	
	@GetMapping("/addLargeStatistics")
	public String addLargeStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 대분류 상품 통계 입력");
		model.addAttribute("titleName", "대분류 상품 통계 입력");
		
		return "statistics/addLargeStatistics";
	}
	
	@GetMapping("/modifyLargeStatistics")
	public String modifyLargeStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 대분류 상품 통계 수정");
		model.addAttribute("titleName", "대분류 상품 통계 수정");
		
		return "statistics/modifyLargeStatistics";
	}
	
	@GetMapping("/removeLargeStatistics")
	public String removeLargeStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 대분류 상품 통계 삭제");
		model.addAttribute("titleName", "대분류 상품 통계 삭제");
		
		return "statistics/removeLargeStatistics";
	}
	
	@GetMapping("/getSmallStatistics")
	public String getSmallStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 소분류 상품 통계 조회");
		model.addAttribute("titleName", "소분류 상품 통계 조회");
		
		return "statistics/getSmallStatistics";
	}
	
	@GetMapping("/addSmallStatistics")
	public String addSmallStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 소분류 상품 통계 입력");
		model.addAttribute("titleName", "소분류 상품 통계 입력");
		
		return "statistics/addSmallStatistics";
	}
	
	@GetMapping("/modifySmallStatistics")
	public String modifySmallStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 소분류 상품 통계 수정");
		model.addAttribute("titleName", "소분류 상품 통계 수정");
		
		return "statistics/modifySmallStatistic";
	}
	
	@GetMapping("/removeSmallStatistics")
	public String removeSmallStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 소분류 상품 통계 삭제");
		model.addAttribute("titleName", "소분류 상품 통계 삭제");
		
		return "statistics/removeSmallStatistics";
	}
	@GetMapping("/getNomalPrice")
	public String getNomalPrice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 정상가 시세 조회");
		model.addAttribute("titleName", "정상가 시세 조회");
		
		return "statistics/getNomalPrice";
	}
	
	@GetMapping("/addNomalPrice")
	public String addNomalPrice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 정상가 시세 입력");
		model.addAttribute("titleName", "정상가 시세 입력");
		
		return "statistics/addNomalPrice";
	}
	
	@GetMapping("/modifyNomalPrice")
	public String modifyNomalPrice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 정상가 시세 수정");
		model.addAttribute("titleName", "정상가 시세 수정");
		
		return "statistics/modifyNomalPrice";
	}
	
	@GetMapping("/removeNomalPrice")
	public String removeNomalPrice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 정상가 시세 삭제");
		model.addAttribute("titleName", "정상가 시세 삭제");
		
		return "statistics/removeNomalPrice";
	}
	@GetMapping("/getVisitHistory")
	public String getVisitHistory(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 방문 내역 통계 조회");
		model.addAttribute("titleName", "방문 내역 통계 조회");
		
		return "statistics/getVisitHistory";
	}
	
	@GetMapping("/addVisitHistory")
	public String addVisitHistory(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 방문 내역 통계 입력");
		model.addAttribute("titleName", "방문 내역 통계 입력");
		
		return "statistics/addVisitHistory";
	}
	
	@GetMapping("/modifyVisitHistory")
	public String modifyVisitHistory(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 방문 내역 통계 수정");
		model.addAttribute("titleName", "방문 내역 통계 수정");
		
		return "statistics/modifyVisitHistory";
	}
	
	@GetMapping("/removeVisitHistory")
	public String removeVisitHistory(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 방문 내역 통계 삭제");
		model.addAttribute("titleName", "방문 내역 통계 삭제");
		
		return "statistics/removeVisitHistory";
	}
	
	@GetMapping("/getAdStatistics")
	public String getAdStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 광고 통계 조회");
		model.addAttribute("titleName", "광고 통계 조회");
		
		return "statistics/getAdStatistics";
	}
	
	@GetMapping("/addAdStatistics")
	public String addAdStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 광고 통계 입력");
		model.addAttribute("titleName", "광고 통계 입력");
		
		return "statistics/addAdStatistics";
	}
	
	@GetMapping("/modifyAdStatistics")
	public String modifyAdStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 광고 통계 수정");
		model.addAttribute("titleName", "광고 통계 수정");
		
		return "statistics/modifyAdStatistics";
	}
	
	@GetMapping("/removeAdStatistics")
	public String removeAdStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 광고 통계 삭제");
		model.addAttribute("titleName", "광고 통계 삭제");
		
		return "statistics/removeAdStatistics";
	}
	
}
