package com.kfarmstar.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.admin.mapper.StatisticsMapper;
import com.kfarmstar.admin.service.GoodsService;
import com.kfarmstar.admin.service.StatisticsService;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.Statistics;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	private static final Logger log = LoggerFactory.getLogger(NoticeBoardController.class);
		
	private StatisticsService statisticsService;
	private StatisticsMapper statisticsMapper;
	private GoodsService goodsService;
	private GoodsMapper goodsMapper;
	
	public StatisticsController(StatisticsService statisticsService, StatisticsMapper statisticsMapper, GoodsService goodsService, GoodsMapper goodsMapper) {
		this.statisticsService = statisticsService;
		this.statisticsMapper = statisticsMapper;
		this.goodsService = goodsService;
		this.goodsMapper = goodsMapper;
	}

	
	@GetMapping("/getGoodsStatistics")
	public String getGoodsStatistics(Model model
									,@RequestParam(value="startDate", required = false) String startDate
									,@RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		System.out.println("getGoodsStatistics StatisticsController.java");
		
		List<Statistics> goodsStatisticsList = statisticsService.getGoodsStatisticsList(startDate, endDate);
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		
		model.addAttribute("title", "FoodRefurb : 상품 통계 조회");
		model.addAttribute("titleName", "상품 통계 조회");
		model.addAttribute("goodsStatisticsList", goodsStatisticsList);
		model.addAttribute("largeCateList", largeCateList);
		
		
		return "statistics/getGoodsStatistics";
	}
	
	@GetMapping("/goodsTypeStatisticsList")
	public String goodsTypeStatisticsList(Model model
											,@RequestParam(value="goodsSmallCate", required = false) String goodsSmallCate) {
		
		log.info("상품별 통계 목록 조회:{}", goodsSmallCate);
		
		List<Statistics> goodsTypeStatisticsList = statisticsService.goodsTypeStatisticsList(goodsSmallCate);
		
		model.addAttribute("goodsStatisticsList", goodsTypeStatisticsList);
		
		return "statistics/getGoodsStatistics";
	}
	/**
	 * 대분류 코드에 해당하는 소분류 카테고리 목록 불러오기
	 * 카테고리 ajax
	 */
	@PostMapping("/getSmallCateList")
	@ResponseBody
	public List<GoodsSmall> getSmallCateList(@RequestParam(value = "goodsLargeCate") String goodsLargeCate) {
		
		return goodsMapper.getSmallCateList(goodsLargeCate);
	}
	
	
	@GetMapping("/addGoodsStatistics")
	public String addGoodsStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품 통계 입력");
		model.addAttribute("titleName", "상품 통계 입력");
		
		return "statistics/addGoodsStatistics";
	}
	
	@GetMapping("/modifyGoodsStatistics")
	public String modifyGoodsStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품 통계 수정");
		model.addAttribute("titleName", "상품 통계 수정");
		
		return "statistics/modifyGoodsStatistics";
	}
	
	@GetMapping("/removeGoodsStatistics")
	public String removeGoodsStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 상품 통계 삭제");
		model.addAttribute("titleName", "상품 통계 삭제");
		
		return "statistics/removeGoodsStatistics";
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
