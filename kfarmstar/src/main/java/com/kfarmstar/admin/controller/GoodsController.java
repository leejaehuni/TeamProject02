package com.kfarmstar.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.admin.service.GoodsService;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	

	
	
	/**
	 * 상품 등록 화면
	 * @GetMapping("/addGoods")
	 * @param 
	 * @return
	 */
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		log.info("상품 등록 화면");
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		model.addAttribute("title", "FoodRefurb : 상품 등록");
		model.addAttribute("titleName", "상품 등록");
		model.addAttribute("largeCateList", largeCateList);
		log.info("상품 대분류 카테고리 : {}",largeCateList);
		
		return "goods/addGoods";
	}

	
	
	@GetMapping("/addLargeCate")
	public String addLargeCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 대분류 카테고리 등록");
		model.addAttribute("titleName", "상품 대분류 카테고리 등록");
		
		return "goods/addLargeCate";
	}
	
	@PostMapping("/addLargeCate")
	public String addLargeCate(GoodsLarge goodsLarge) {
		
		goodsService.addLargeCate(goodsLarge);
		log.info("상품 대분류 카테고리 등록 폼 입력값: {}", goodsLarge); //받은 내용이 여기{}에 담긴다.
		
		return "redirect:/goods/goodsCateList";
	}
	
	
	
	@GetMapping("/addSmallCate")
	public String addSmallCate(Model model) {
		// 대분류 카테고리 리스트
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();
		model.addAttribute("title", "FoodRefurb : 상품 소분류 카테고리 등록");
		model.addAttribute("titleName", "상품 소분류 카테고리 등록");
		model.addAttribute("largeCateList", largeCateList);
		
		return "goods/addSmallCate";
	}
	
	@PostMapping("/addSmallCate")
	public String addSmallCate(GoodsSmall goodsSmall) {
		
		goodsService.addSmallCate(goodsSmall);
		log.info("상품 소분류 카테고리 등록 폼 입력값: {}", goodsSmall);
		
		return "redirect:/goods/goodsCateList"; 
	}
	
	
	/**
	 * 상품 카테고리 목록을 보여준다
	 * @param model
	 * @return
	 */
	@GetMapping("/goodsCateList")
	public String getGoodsCateList(Model model) {
		
		log.info("상품 카테고리 목록 요청");

		model.addAttribute("title", "FoodRefurb : 상품 카테고리 목록");
		model.addAttribute("titleName", "상품 카테고리 목록");
		
		List<GoodsSmall> goodsCateList = goodsService.getGoodsCateList();
		model.addAttribute("goodsCateList", goodsCateList);
		log.info("상품 카테고리 목록 : {}", goodsCateList);
		
		return "goods/goodsCateList";
	}
	
	
	@GetMapping("/goodsDetail")
	public String getDetailGoodsInfo(Model model
									,@RequestParam(name="goodsRefurbCode", required = false) String goodsRefurbCode
									,@RequestParam(name="goodsSmallCate", required = false) String goodsSmallCate) {
		
		Goods goods = goodsService.getGoodsByCode(goodsRefurbCode);			//각 상품별 정보
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		GoodsSmall goodsSmall = goodsService.getSmallCateInfoByCode(goodsSmallCate);
		log.info("상품별 상세정보");
		log.info("상품 폼 쿼리스트링 goodsRefurbCode : {}", goodsRefurbCode);
		
		model.addAttribute("title", "FoodRefurb : 상품 정보");
		model.addAttribute("titleName", "상품 상세 정보");
		model.addAttribute("goods", goods);
		model.addAttribute("largeCateList", largeCateList);
		model.addAttribute("goodsSmall", goodsSmall);
		
		return "goods/goodsDetail";
	}
	
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		
		List<Goods> goodsList = goodsService.getGoodsList();
		model.addAttribute("title", "FoodRefurb : 상품 목록");
		model.addAttribute("titleName", "상품 목록");
		model.addAttribute("goodsList", goodsList);
		
		return "goods/goodsList";
	}
	
	
	@GetMapping("/modifyGoods")
	public String modifyGoods(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 수정");
		model.addAttribute("titleName", "상품 수정");
		
		return "goods/modifyGoods";
	}
	
	/**
	 * 상품 카테고리 수정화면 
	 */
	@GetMapping("/modifyGoodsCate")
	public String modifyGoodsCate(Model model
								,@RequestParam(name="goodsSmallCate", required = false) String goodsSmallCate) {
		
		log.info("상품소분류 카테고리 수정");
		log.info("상품소분류 카테고리 폼 쿼리스트링 goodsSmallCate : {}", goodsSmallCate);
		GoodsSmall goodsSmall = goodsService.getSmallCateInfoByCode(goodsSmallCate);
		
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 수정");
		model.addAttribute("titleName", "상품 카테고리 수정");
		model.addAttribute("goodsSmall", goodsSmall);
		model.addAttribute("largeCateList", largeCateList);
		
		log.info("goodsSmall 리스트 : {}", goodsSmall);
		log.info("대분류 리스트 : {}", largeCateList);
		
		return "goods/modifyGoodsCate";
	}
	
	/**
	 * 상품 카테고리 수정처리 
	 */
	@PostMapping("/modifyGoodsCate")
	public String modifyGoodsCate(GoodsSmall goodsSmall) {
		
		log.info("카테고리 수정화면에서 입력받은 값: {}", goodsSmall);
		goodsService.modifyGoodsCate(goodsSmall);
		return "redirect:/goods/goodsCateList";
	}
	
	
	@GetMapping("/removeGoods")
	public String removeGoods(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 삭제");
		model.addAttribute("titleName", "상품 삭제");
		
		return "goods/removeGoods";
	}
	
	@GetMapping("/removeGoodsCate")
	public String removeGoodsCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 삭제");
		model.addAttribute("titleName", "상품 카테고리 삭제");
		
		return "goods/removeGoodsCate";
	}

}
