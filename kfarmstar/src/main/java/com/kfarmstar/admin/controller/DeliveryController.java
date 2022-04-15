package com.kfarmstar.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.admin.service.DeliveryService;
import com.kfarmstar.dto.CompanyEmployee;
import com.kfarmstar.dto.DeliveryCompany;
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
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 목록 조회");
		model.addAttribute("titleName", "배송 회사 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("companyList", companyList);
		
		return "delivery/getCompanyList";
	}
	
	/* 회사 직원 목록 조회 폼 */
	@GetMapping("/getEmployeeList")
	public String getEmployeeList(Model model) {
		
		log.info("직원 목록 조회");
		
		List<CompanyEmployee> employeeList = deliveryService.getEmployeeList();
		
		model.addAttribute("title", "FoodRefurb : 직원 목록 조회");
		model.addAttribute("titleName", "직원 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("employeeList", employeeList);
		
		return "delivery/getEmployeeList";
	}

	/* 운송장 목록 조회 폼 */
	@GetMapping("/getDeliveryList")
	public String getDeliveryList(Model model) {
		
		log.info("운송장 목록 조회");
		
		//List<DeliveryGoods> deliveryList = deliveryService.getDeliveryList();
		
		log.info("c 1");
		model.addAttribute("title", "FoodRefurb : 운송장 목록 조회");
		model.addAttribute("titleName", "운송장 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		//model.addAttribute("deliveryList", deliveryList);
		log.info("c 2");
		
		return "delivery/getDeliveryList";
	}
	
	/* 배송 집하 목록 조회 폼 */
	@GetMapping("/getPickupList")
	public String getPickupList(Model model) {
		
		log.info("집하 목록 조회");
		
		List<DeliveryPickup> pickupList = deliveryService.getPickupList();
		
		model.addAttribute("title", "FoodRefurb : 집하 목록 조회");
		model.addAttribute("titleName", "집하 목록 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("pickupList", pickupList);
		
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
		
		model.addAttribute("title", "FoodRefurb : 회사 내역 조회");
		model.addAttribute("titleName", "회사 내역 조회");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("getDeliveryCompany", getDeliveryCompany);
		
		return "delivery/getCompany";
	}
	
	/* 배송 운송장 내역 조회 폼 */
	@GetMapping("/getDelivery")
	public String getDelivery(Model model) {
		
		log.info("운송장 조회");
		
		//List<DeliveryGoods> getDeliveryDetail = deliveryService.getDelivery();
		
		log.info("c 1");
		model.addAttribute("title", "FoodRefurb : 운송장 조회");
		model.addAttribute("titleName", "운송장 조회");
		model.addAttribute("titleMenu", "배송 관리");
		//model.addAttribute("getDeliveryDetail", getDeliveryDetail);
		log.info("c 2");
		
		return "delivery/getDelivery";
	}
	
	
	
	
	
	/************************************************************
	 * 이용자 체크 기능
	 ************************************************************/
	
	/* 운송장 조회 이용자 권한 및 내역 체크 폼 */
	@GetMapping("/checkDelivery")
	public String checkDelivery(Model model) {
		
		log.info("운송장 조회 이용자 체크");
		
		model.addAttribute("title", "FoodRefurb : 운송장 조회 이용자 체크");
		model.addAttribute("titleName", "운송장 조회 이용자 체크");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/checkDelivery";
	}
	
	/* 집하 조회 이용자 권한 및 내역 체크 폼 */
	@GetMapping("/checkPickupList")
	public String checkPickupList(Model model) {
		
		log.info("집하 조회 이용자 체크");
		
		model.addAttribute("title", "FoodRefurb : 집하 조회 이용자 체크");
		model.addAttribute("titleName", "집하 조회 이용자 체크");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/checkPickupList";
	}
	
	/* 배송 회사 조회 이용자 권한 및 내역 체크 폼 */
	@GetMapping("/checkCompany")
	public String checkCompany(Model model
								,HttpSession session) {
		
		log.info("회사 조회 이용자 체크 : {}", session.getAttribute("SID"));
		
		model.addAttribute("title", "FoodRefurb : 회사 조회 이용자 체크");
		model.addAttribute("titleName", "회사 조회 이용자 체크");
		model.addAttribute("titleMenu", "배송 관리");
		model.addAttribute("session", session.getAttribute("SID"));
		
		return "delivery/checkCompany";
	}
	
	/* 회사 직원 조회 이용자 권한 및 내역 체크 폼 */
	@GetMapping("/checkEmployee")
	public String checkEmployee(Model model) {
		
		log.info("직원 조회 이용자 체크");
		
		model.addAttribute("title", "FoodRefurb : 직원 조회 이용자 체크");
		model.addAttribute("titleName", "직원 조회 이용자 체크");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/checkEmployee";
	}

	
	

	
	/************************************************************
	 * 내역 등록 기능
	 ************************************************************/
	
	/* 배송 회사 등록(회사,직원)선택 폼 */
	@GetMapping("/addCompanyList")
	public String addCompanyList(Model model) {
		
		log.info("회사 내역 등록 선택지");
		
		model.addAttribute("title", "FoodRefurb : 회사 내역 등록 선택지");
		model.addAttribute("titleName", "회사 내역 등록 선택지");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/addCompanyList";
	}
	
	/* 배송 회사 등록 폼 */
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		
		log.info("회사 등록");
		
		model.addAttribute("title", "FoodRefurb : 회사 등록");
		model.addAttribute("titleName", "회사 등록");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/addCompany";
	}
	
	/* 회사 직원 등록 폼 */
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		
		log.info("직원 등록");
		
		model.addAttribute("title", "FoodRefurb : 직원 등록");
		model.addAttribute("titleName", "직원 등록");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/addEmployee";
	}
	
	/* 배송 등록 폼 */
	@GetMapping("/addDelivery")
	public String addDelivery(Model model) {
		
		log.info("배송 등록");
		
		model.addAttribute("title", "FoodRefurb : 배송 등록");
		model.addAttribute("titleName", "배송 등록");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/addDelivery";
	}
	
	/* 집하 등록 폼 */
	@GetMapping("/addPickup")
	public String addPickup(Model model) {
		
		log.info("집하 등록");
		
		model.addAttribute("title", "FoodRefurb : 집하 등록");
		model.addAttribute("titleName", "집하 등록");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/addPickup";
	}
	
	
	
	
	
	/************************************************************
	 * 내역 수정 기능
	 ************************************************************/
	
	/* 배송 회사 내역 수정 폼 */
	@GetMapping("/modifyCompany")
	public String modifyCompany(Model model) {
		
		log.info("회사 내역 수정");
		
		log.info("c 1");
		model.addAttribute("title", "FoodRefurb : 회사 내역 수정");
		model.addAttribute("titleName", "회사 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		log.info("c 2");
		
		return "delivery/modifyCompany";
	}
	
	/* 회사 직원 내역 수정 폼 */
	@GetMapping("/modifyEmployee")
	public String modifyEmployee(Model model) {
		
		log.info("직원 내역 수정");
		
		model.addAttribute("title", "FoodRefurb : 직원 내역 수정");
		model.addAttribute("titleName", "직원 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/modifyEmployee";
	}
	
	/* 운송장 내역 수정 폼 */
	@GetMapping("/modifyDelivery")
	public String modifyDelivery(Model model) {
		
		log.info("운송장 내역 수정");
		
		model.addAttribute("title", "FoodRefurb : 운송장 내역 수정");
		model.addAttribute("titleName", "운송장 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
		return "delivery/modifyDelivery";
	}
	
	/* 집하 내역 수정 폼 */
	@GetMapping("/modifyPickup")
	public String modifyPickup(Model model) {
		
		log.info("집하 내역 수정");
		
		model.addAttribute("title", "FoodRefurb : 집하 내역 수정");
		model.addAttribute("titleName", "집하 내역 수정");
		model.addAttribute("titleMenu", "배송 관리");
		
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
