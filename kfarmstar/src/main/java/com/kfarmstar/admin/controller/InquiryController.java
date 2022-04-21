package com.kfarmstar.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfarmstar.admin.service.DeliveryService;
import com.kfarmstar.admin.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);
	
	private InquiryService inquiryService;
	
	public InquiryController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}
	
	/************************************************************
	 * 목록 조회 기능
	 ************************************************************/
	
	/* 카테고리 목록 조회 */
	@GetMapping("/getCategoryList")
	public String getCategoryList(Model model) {
		
		log.info("카테고리 목록 조회");
		
		model.addAttribute("title", "FoodRefurb : 카테고리 목록");
		model.addAttribute("titleName", "카테고리 목록");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/getCategoryList";
	}
	
	/* 문의 목록 조회 */
	@GetMapping("/getInquiryList")
	public String getInquiryList(Model model) {
		
		log.info("문의 목록 조회");
		
		model.addAttribute("title", "FoodRefurb : 문의 목록");
		model.addAttribute("titleName", "문의 목록");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/getInquiryList";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 등록 기능
	 ************************************************************/
	
	/* 문의 카테고리 등록 */
	@GetMapping("/addCategory")
	public String addCategory(Model model) {
		
		log.info("카테고리 등록");
		
		model.addAttribute("title", "FoodRefurb : 카테고리 등록");
		model.addAttribute("titleName", "카테고리 등록");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/addCategory";
	}
	
	/* 문의 내역 등록 */
	@GetMapping("/addInquiry")
	public String addInquiry(Model model) {
		
		log.info("문의 등록");
		
		model.addAttribute("title", "FoodRefurb : 문의 등록");
		model.addAttribute("titleName", "문의 등록");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/addInquiry";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 수정 기능
	 ************************************************************/

	/* 문의 내역 수정 */
	@GetMapping("/modifyInquiry")
	public String modifyInquiry(Model model) {
		
		log.info("문의 내역 수정");		
		model.addAttribute("title", "FoodRefurb : 문의 내역 수정");
		model.addAttribute("titleName", "문의 내역 수정");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/modifyInquiry";
	}
	
	/* 문의 답변 내역 수정 */
	@GetMapping("/modifyAnswer")
	public String modifyAnswer(Model model) {
		
		log.info("문의 답변 내역 수정");
		
		model.addAttribute("title", "FoodRefurb : 답변 내역 수정");
		model.addAttribute("titleName", "답변 내역 수정");
		model.addAttribute("titleMenu", "문의 관리");
		
		return "inquiry/modifyAnswer";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 삭제 기능
	 ************************************************************/
	
	/* 문의 내역 삭제 */
	/* 문의 답변 내역 삭제*/
}
