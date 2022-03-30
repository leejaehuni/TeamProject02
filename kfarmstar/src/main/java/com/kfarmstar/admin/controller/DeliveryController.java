package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	/************************************************************
	 * 배송 회사 목록 조회 폼
	 ************************************************************/
	@GetMapping("/getCompanyList")
	public String getCompanyList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 목록");
		model.addAttribute("titleName", "배송 회사 목록");
		
		return "delivery/getCompanyList";
	}
	
	/************************************************************
	 * 배송 회사 정보 조회 폼
	 ************************************************************/
	@GetMapping("/getCompany")
	public String getCompany(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 정보 조회");
		model.addAttribute("titleName", "회사 정보 조회");
		
		return "delivery/getCompany";
	}
	
	/************************************************************
	 * 배송 회사 사원 조회 폼
	 ************************************************************/
	@GetMapping("/getEmployee")
	public String getEmployee(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사원 조회");
		model.addAttribute("titleName", "사원 조회");
		
		return "delivery/getEmployee";
	}
	
	/************************************************************
	 * 배송 운송장 정보 조회 폼
	 ************************************************************/
	@GetMapping("/getDelivery")
	public String getDelivery(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 운송장 조회");
		model.addAttribute("titleName", "운송장 조회");
		
		return "delivery/getDelivery";
	}
	
	/************************************************************
	 * 배송 집하 내역 목록 조회 폼
	 ************************************************************/
	@GetMapping("/getWarehouseList")
	public String getWarehouseList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 집하 내역 목록 조회");
		model.addAttribute("titleName", "배송 집하 내역 조회");
		
		return "delivery/getWarehouseList";
	}

	/************************************************************
	 * 배송 회사 선택 목록 조회 폼
	 ************************************************************/
	@GetMapping("/addCompanyList")
	public String addCompanyList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 선택 목록");
		model.addAttribute("titleName", "회사 선택 목록");
		
		return "delivery/addCompanyList";
	}
	
	/************************************************************
	 * 운송장 내역 조회 이용자 권한 및 정보 체크 폼
	 ************************************************************/
	@GetMapping("/checkDelivery")
	public String checkDelivery(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 운송장 내역 이용자 체크");
		model.addAttribute("titleName", "운송장 내역 이용자 체크");
		
		return "delivery/checkDelivery";
	}
	
	/************************************************************
	 * 집하 내역 조회 이용자 권한 및 정보 체크 폼
	 ************************************************************/
	@GetMapping("/checkWarehouseList")
	public String checkWarehouseList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 집하 내역 이용자 체크");
		model.addAttribute("titleName", "집하 내역 이용자 체크");
		
		return "delivery/checkWarehouseList";
	}
	
	/************************************************************
	 * 배송 회사 등록 폼
	 ************************************************************/
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 등록");
		model.addAttribute("titleName", "회사 등록");
		
		return "delivery/addCompany";
	}
	
	/************************************************************
	 * 배송 회사 사원 등록 폼
	 ************************************************************/
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사원 등록");
		model.addAttribute("titleName", "사원 등록");
		
		return "delivery/addEmployee";
	}
	
	/************************************************************
	 * 배송 등록 폼
	 ************************************************************/
	@GetMapping("/addDelivery")
	public String addDelivery(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 등록");
		model.addAttribute("titleName", "배송 등록");
		
		return "delivery/addDelivery";
	}
	
	/************************************************************
	 * 배송 집하 내역 등록 폼
	 ************************************************************/
	@GetMapping("/addWarehouse")
	public String addWarehouse(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 집하 내역 등록");
		model.addAttribute("titleName", "집하 내역 등록");
		
		return "delivery/addWarehouse";
	}
	
	/************************************************************
	 * 배송 회사 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyCompany")
	public String modifyCompany(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 정보 수정");
		model.addAttribute("titleName", "회사 정보 수정");
		
		return "delivery/modifyCompany";
	}
	
	/************************************************************
	 * 배송 회사 사원 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyWarehouse")
	public String modifyWarehouse(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사원 정보 수정");
		model.addAttribute("titleName", "사원 정보 수정");
		
		return "delivery/modifyWarehouse";
	}
	
	/************************************************************
	 * 배송 운송장 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyDelivery")
	public String modifyDelivery(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 운송장 정보 수정");
		model.addAttribute("titleName", "운송장 정보 수정");
		
		return "delivery/modifyDelivery";
	}
	
	/************************************************************
	 * 삭제 기능
	 ************************************************************/
	
}
