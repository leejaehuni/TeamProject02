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
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfarmstar.admin.service.DonorPlaceService;
import com.kfarmstar.dto.DonationApply;
import com.kfarmstar.dto.DonationPlace;

@Controller
@RequestMapping("/donations")
public class DonorPlaceController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DonorPlaceController.class);

	private DonorPlaceService donorPlaceService;
	
	public DonorPlaceController(DonorPlaceService donorPlaceService) {
		this.donorPlaceService = donorPlaceService;
	}
	
	/*********************
	 *    기부 사용처 관리	 *		
	 *********************/
	
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
	public String confirmDonorPlace(DonationApply donationApply, HttpSession session) {
		log.info("dondoorPlaceList DonorPlaceController.java 실행");
		String donorApply = (String) session.getAttribute("SID");
		log.info("donorPlaceList DonorPlaceController.java : ", donorApply);
		List<DonationApply> donorApplyConfirm = donorPlaceService.confirmDonorPlace(donationApply);
		
		return "donations/confirmDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 등록 신청
	 */
	@GetMapping("/applyDonorPlace")
	public String applyDonorPlace(Model model,HttpSession session) {
		log.info("dondoorPlaceList DonorPlaceController.java 실행");
		String donorPlaceId = (String) session.getAttribute("SID");
		log.info("donorPlaceList DonorPlaceController.java : ", donorPlaceId);
		model.addAttribute("title", "기부상품 사용처 등록신청");
		model.addAttribute("titleName", "기부상품 사용처 등록신청");
		model.addAttribute("id", donorPlaceId);
		
		return "donations/applyDonorPlace";
	}
	
	/**
	 * 기부 상품 사용처 등록
	 */
	@GetMapping("/addDonorPlace")
	public String addDonorPlace(Model model, HttpSession session) {
		log.info("addDonorPlace DonorPlaceController.java 실행");
		String donorPlaceId = (String) session.getAttribute("SID");
		log.info("addDonorPlace DonorPlaceController.java 실행", donorPlaceId);
		model.addAttribute("title", "FoodRefurb : 기부 사용처 등록");
		model.addAttribute("titleName", "기부 사용처 등록");
		model.addAttribute("placeId", donorPlaceId);
		
		return "donations/addDonorPlace";
	}
	
	@PostMapping("/addDonorPlace")
	public String addDonorPlace(DonationPlace donationPlace, HttpSession session) {
		
		String donorPlaceId = (String) session.getAttribute("SID");
		donorPlaceService.addDonorPlace(donationPlace, donorPlaceId);
		
		return "redirect:/donations/donorPlaceList";
	}
	
	/**
	 * 패스워드 체크
	 */
	@PostMapping("/passwordCheck")
	@ResponseBody
	private String passwordCheck(String password) {
		
		String passwordCh = "Pw";
		String Result = null;
		if(password == passwordCh) {
			
			Result = "일치";
		} else {
			Result = "불일치";
		}
		
		return Result;
	}
	
	/**
	 * 기부 상품 사용처 목록
	 */
	@GetMapping("/donorPlaceList")
	public String getDonorPlaceList(Model model) {
		log.info("donorPlaceList DonorPlaceController.java 실행");
		List<DonationPlace> donorPlaceList = donorPlaceService.getDonorPlaceList();
		log.info("donorPlaceList DonorPlaceController.java : ", donorPlaceList);
		System.out.println(donorPlaceList.get(0).getDonationApplyNum() + "<- donorPlaceList.get(0).getDonationApplyNum()");
		System.out.println(donorPlaceList.get(0).getDonationIntroduction() + "<- donorPlaceList.get(0).getDonationIntroduction()");
		model.addAttribute("title", "FoodRefurb : 기부 사용처 목록");
		model.addAttribute("titleName", "기부 사용처 목록");
		model.addAttribute("donorPlaceList", donorPlaceList);
		
		return "donations/donorPlaceList";
	}
}
