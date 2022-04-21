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

import com.kfarmstar.admin.service.DeliveryService;
import com.kfarmstar.dto.CompanyEmployee;
import com.kfarmstar.dto.DeliveryCompany;
import com.kfarmstar.dto.DeliveryGoods;
import com.kfarmstar.dto.DeliveryPickup;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	
	private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);
	
	private DeliveryService deliveryService;
	
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	
	
	
	
	/************************************************************
	 * 목록 조회 기능
	 ************************************************************/
	
	/* 배송 회사 목록 조회 폼 */
	@GetMapping("/getCompanyList")
	public String getCompanyList(Model model) {
		
		log.info("배송 회사 목록 조회");
		
		List<DeliveryCompany> companyList = deliveryService.getCompanyList();
		
		log.info("===== controller getCompanyList 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 목록 조회");
		model.addAttribute("titleName", "배송 회사 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("companyList", companyList);

		log.info("===== controller getCompanyList 모델 셋팅 완료 =====");
		
		return "delivery/getCompanyList";
	}
	
	/* 회사 직원 목록 조회 폼 */
	@GetMapping("/getEmployeeList")
	public String getEmployeeList(Model model) {
		
		log.info("직원 목록 조회");
		
		List<CompanyEmployee> employeeList = deliveryService.getEmployeeList();
		
		log.info("===== controller getEmployeeList 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 직원 목록 조회");
		model.addAttribute("titleName", "직원 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("employeeList", employeeList);

		log.info("===== controller getEmployeeList 모델 셋팅 완료 =====");
		
		return "delivery/getEmployeeList";
	}

	/* 운송장 목록 조회 폼 */
	@GetMapping("/getDeliveryList")
	public String getDeliveryList(Model model) {
		
		log.info("운송장 목록 조회");
		
		List<DeliveryGoods> deliveryList = deliveryService.getDeliveryList();
		
		log.info("===== controller getDeliveryList 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 운송장 목록 조회");
		model.addAttribute("titleName", "운송장 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("deliveryList", deliveryList);

		log.info("===== controller getDeliveryList 모델 셋팅 완료 =====");
		
		return "delivery/getDeliveryList";
	}
	
	/* 배송 집하 목록 조회 폼 */
	@GetMapping("/getPickupList")
	public String getPickupList(Model model
								/* ,HttpSession session */) {
		
		log.info("집하 목록 조회");
		
		//String sessionId = (String) session.getAttribute("SID");
		List<DeliveryPickup> pickupList = deliveryService.getPickupList();
		
		log.info("===== controller getPickupList 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 집하 목록 조회");
		model.addAttribute("titleName", "집하 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		//model.addAttribute("sessionId", sessionId);
		model.addAttribute("pickupList", pickupList);

		log.info("===== controller getPickupList 모델 셋팅 완료 =====");
		
		return "delivery/getPickupList";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 조회 기능
	 ************************************************************/
	
	/* 배송 회사 내역 조회 폼 */
	@GetMapping("/getCompany")
	public String getCompany(Model model
							 ,@RequestParam(name="companyCode", required = false) String companyCode) {
		
		log.info("회사 내역 조회 : {}", companyCode);
		
		DeliveryCompany getDeliveryCompany = deliveryService.getCompany(companyCode);
		
		log.info("===== controller getCompany 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 회사 내역 조회");
		model.addAttribute("titleName", "회사 내역 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("getDeliveryCompany", getDeliveryCompany);

		log.info("===== controller getCompany 모델 셋팅 완료 =====");
		
		return "delivery/getCompany";
	}
	
	/* 배송 운송장 내역 조회 폼 */
	@GetMapping("/getDelivery")
	public String getDelivery(Model model
								,@RequestParam(name="deliveryNum", required = false) String deliveryNum) {
		
		log.info("운송장 조회 : {}", deliveryNum);
		
		DeliveryGoods getDeliveryDetail = deliveryService.getDelivery(deliveryNum);
		
		log.info("===== controller getDelivery 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 운송장 조회");
		model.addAttribute("titleName", "운송장 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("getDeliveryDetail", getDeliveryDetail);

		log.info("===== controller getDelivery 모델 셋팅 완료 =====");
		
		return "delivery/getDelivery";
	}

	
	

	
	/************************************************************
	 * 내역 등록 기능
	 ************************************************************/
	
	/* 배송 회사 등록(회사,직원)선택 폼 */
	@GetMapping("/addCompanyList")
	public String addCompanyList(Model model) {
		
		log.info("회사 내역 등록 선택지");
		
		log.info("===== controller addCompanyList 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 회사 내역 등록 선택지");
		model.addAttribute("titleName", "회사 내역 등록 선택지");
		model.addAttribute("titleMenu", "배송 관리");

		log.info("===== controller addCompanyList 모델 셋팅 완료 =====");
		
		return "delivery/addCompanyList";
	}
	
	/* 배송 회사 등록 폼 */
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		
		log.info("회사 등록");
		
		log.info("===== controller addCompany 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 회사 등록");
		model.addAttribute("titleName", "회사 등록");
		model.addAttribute("titleMenu", "배송 관리");

		log.info("===== controller addCompany 모델 셋팅 완료 =====");
		
		return "delivery/addCompany";
	}
	
	/* 회사 직원 등록 폼 */
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		
		log.info("직원 등록");
		
		log.info("===== controller addEmployee 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 직원 등록");
		model.addAttribute("titleName", "직원 등록");
		model.addAttribute("titleMenu", "배송 관리");

		log.info("===== controller addEmployee 모델 셋팅 완료 =====");
		
		return "delivery/addEmployee";
	}
	
	/* 배송 등록 폼 */
	@GetMapping("/addDelivery")
	public String addDelivery(Model model) {
		
		log.info("배송 등록");
		
		List<DeliveryGoods> addDeliveryCompany = deliveryService.addDeliveryCompany();
		List<DeliveryGoods> addDeliveryGoods = deliveryService.addDeliveryGoods();
		
		log.info("===== controller addDelivery 서비스 값 받아오기 완료 =====");
		log.info("addDelivery addDeliveryCompany 값 : {}", addDeliveryCompany);
		log.info("addDelivery addDeliveryGoods 값 : {}", addDeliveryGoods);
		
		model.addAttribute("title", "FoodRefurb : 배송 등록");
		model.addAttribute("titleName", "배송 등록");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("addDeliveryCompany", addDeliveryCompany);
		log.info("===== controller addDelivery addDeliveryCompany 모델 셋팅 완료 =====");
		
		model.addAttribute("addDeliveryGoods", addDeliveryGoods);
		log.info("===== controller addDelivery addDeliveryGoods 모델 셋팅 완료 =====");
		
		return "delivery/addDelivery";
	}
	
	@PostMapping("/changeDelivery")
	public List<DeliveryCompany> changeDelivery(@RequestParam(name="companyName", required = false) String companyName) {
		List<DeliveryCompany> cDelivery = null;
		
		log.info("addDelivery deliveryGoods 값 : {}", companyName);
		
		cDelivery = deliveryService.changeDelivery();
		
		log.info("===== controller changeDelivery @GetMapping 등록 처리 완료=====");
		
		return cDelivery;
	}
	
	
	/* 집하 등록 폼 */
	@GetMapping("/addPickup")
	public String addPickup(Model model) {
		
		log.info("집하 등록");
		
		log.info("===== controller addPickup 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 집하 등록");
		model.addAttribute("titleName", "집하 등록");
		model.addAttribute("titleMenu", "배송 관리");

		log.info("===== controller addPickup 모델 셋팅 완료 =====");
		
		return "delivery/addPickup";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 수정 기능
	 ************************************************************/
	
	/* 배송 회사 내역 수정 폼 */
	@GetMapping("/modifyCompany")
	public String modifyCompany(Model model) {
		
		log.info("회사 내역 수정");
		
		log.info("===== controller modifyCompany 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 회사 내역 수정");
		model.addAttribute("titleName", "회사 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");

		log.info("===== controller modifyCompany 모델 셋팅 완료 =====");
		
		return "delivery/modifyCompany";
	}
	
	/* 회사 직원 내역 수정 폼 */
	@GetMapping("/modifyEmployee")
	public String modifyEmployee(Model model) {
		
		log.info("직원 내역 수정");
		
		log.info("===== controller modifyEmployee 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 직원 내역 수정");
		model.addAttribute("titleName", "직원 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
		log.info("===== controller modifyEmployee 모델 셋팅 완료 =====");
		
		return "delivery/modifyEmployee";
	}
	
	/* 운송장 내역 수정 폼 */
	@GetMapping("/modifyDelivery")
	public String modifyDelivery(Model model) {
		
		log.info("운송장 내역 수정");
		
		log.info("===== controller modifyDelivery 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 운송장 내역 수정");
		model.addAttribute("titleName", "운송장 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
		log.info("===== controller modifyDelivery 모델 셋팅 완료 =====");
		
		return "delivery/modifyDelivery";
	}
	
	/* 집하 내역 수정 폼 */
	@GetMapping("/modifyPickup")
	public String modifyPickup(Model model) {
		
		log.info("집하 내역 수정");
		
		log.info("===== controller modifyPickup 서비스 값 받아오기 완료 =====");
		
		model.addAttribute("title", "FoodRefurb : 집하 내역 수정");
		model.addAttribute("titleName", "집하 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
		log.info("===== controller modifyPickup 모델 셋팅 완료 =====");
		
		return "delivery/modifyPickup";
	}
	
	
	
	
	
	/************************************************************
	 * 삭제 기능
	 ************************************************************/
	
	/* 배송 회사 삭제 */
	/* 회사 직원 삭제 */
	/* 운송장 정보 삭제 */
	/* 집하 내역 삭제 */
}
