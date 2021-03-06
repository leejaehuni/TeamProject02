package com.kfarmstar.user.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.dto.Goods;
import com.kfarmstar.user.service.UserGoodsService;

@Controller
@RequestMapping("/userGoods")
public class UserGoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserGoodsController.class);

	
	private UserGoodsService userGoodsService;
	
	public UserGoodsController(UserGoodsService userGoodsService) {
		this.userGoodsService = userGoodsService;
	}
	
	
	/*
	 * 작성자 : 이지수
	 * 작성일자 : 22-04-13
	 * 사용자 화면 - 상품 상세 정보 조회
	 */
	@GetMapping("/userGoodsDetail")
	public String getShopGoodsDetail(Model model
									,@RequestParam(name="goodsRefurbCode", required = false) String goodsRefurbCode) {
		log.info("상품별 상세정보");
		Goods goods = userGoodsService.getUserGoodsByCode(goodsRefurbCode);	//각 상품별 정보
		List<Goods> randomGoods = userGoodsService.getRandomGoods(goodsRefurbCode); // 특정 상품 제외 후 네 가지 상품 정보 랜덤 조회
		
		
		  NumberFormat numberFormat = NumberFormat.getInstance(); 
		  int refurbPrice = Integer.parseInt(goods.getGoodsRefurbPrice()); 
		  int normalPrice = Integer.parseInt(goods.getGoodsNormalPrice());
		  
		  String refurbResult = numberFormat.format(refurbPrice); 
		  String nomalResult = numberFormat.format(normalPrice);
		  

		 
		
		model.addAttribute("title", "Food Refurb : 개인 상품");	
		model.addAttribute("breadTitle", "Refurb Goods");
		model.addAttribute("breadSubTitle", "Goods Info");
		model.addAttribute("refurbResult", refurbResult + " 원");
		model.addAttribute("nomalResult", nomalResult + " 원");
		
		/*
		 * FileDto file = goods.getFileList().get(0);
		 * model.addAttribute("goodsFile",file);
		 */
		
		model.addAttribute("goods", goods);	
		model.addAttribute("randomGoods", randomGoods);	
		
		return "userGoods/userGoodsDetail";
	}

	
	
	/*
	 * 작성자 : 이지수
	 * 작성일자 : 22-04-11
	 * 사용자 화면 - 상품 목록 조회
	 */
	@GetMapping("/userGoodsList")
	public String getUserGoodsList(Model model
								, @RequestParam(value="searchCate", required = false) String searchCate
								, @RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("상품 목록 요청");
		log.info("searchCate:{}", searchCate);
		log.info("searchValue:{}", searchValue);
		Map<String, Object> paramMap = new HashMap<String , Object>();
		List<Goods> adGoods = userGoodsService.getAdGoods();
		
		paramMap.put("searchCate", searchCate);
		paramMap.put("searchValue", searchValue);
		
		List<Goods> goodsList = userGoodsService.getUserGoodsList(paramMap);
		paramMap = null;
		
		model.addAttribute("title", "Food Refurb : 상품");
		model.addAttribute("breadTitle", "Refurb Goods");
		model.addAttribute("breadSubTitle", "Goods List");
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("adGoods", adGoods);
		
		return "userGoods/userGoodsList";
	}
}
