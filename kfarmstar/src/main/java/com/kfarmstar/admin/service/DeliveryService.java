package com.kfarmstar.admin.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfarmstar.admin.mapper.DeliveryMapper;
import com.kfarmstar.dto.CompanyEmployee;
import com.kfarmstar.dto.DeliveryCompany;
import com.kfarmstar.dto.DeliveryPickup;


@Service
public class DeliveryService {
	
	private static final Logger log = LoggerFactory.getLogger(DeliveryService.class);

	//DI 의존성 주입
	private DeliveryMapper deliveryMapper;
	
	@Autowired
	public DeliveryService(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}
	
	//배송 회사 목록 조회
	public List<DeliveryCompany> getCompanyList() {
		
		List<DeliveryCompany> companyList = deliveryMapper.getCompanyList();
		
		return companyList;
	}
	
	//회사 직원 목록 조회
	public List<CompanyEmployee> getEmployeeList() {
		
		List<CompanyEmployee> employeeList = deliveryMapper.getEmployeeList();
		
		return employeeList;
	}
	
	//운송장 목록 조회
	/*
	public List<DeliveryGoods> getDeliveryList() {
  
		log.info("s 1");
		List<DeliveryGoods> deliveryList = deliveryMapper.getDeliveryList();
		log.info("s 2");
  
		return deliveryList; 
	}
	*/
	
	//집하 목록 조회
	public List<DeliveryPickup> getPickupList() {
		
		List<DeliveryPickup> pickupList = deliveryMapper.getPickupList();
		
		return pickupList;
	}
	
	//배송 회사 내역 조회
	public DeliveryCompany getCompany(String companyCode) {
		
		return deliveryMapper.getCompany(companyCode);
	}
	
	
	//배송 운송장 내역 조회
	/*
	public List<DeliveryGoods> getDelivery() {
		
		log.info("s 1");
		List<DeliveryGoods> getDeliveryDetail = deliveryMapper.getDelivery();
		log.info("s 2");
		
		return getDeliveryDetail;
	}
	*/
	
	//배송 회사 내역 수정
	/*
	public List<DeliveryCompany> modifyCompany() {
		
		log.info("s 1");
		List<DeliveryCompany> modifyCompanyDetail = deliveryMapper.modifyCompany();
		log.info("s 2");
		
		return modifyCompanyDetail;
	}
	*/
	
	//회사 직원 내역 수정

	//운송장 내역 수정
	//집하 내역 수정
	
	//배송 회사 등록
	//회사 직원 등록
	//배송 등록
	//집하 등록
	
	//배송 회사 삭제
	//회사 직원 삭제
	//운송장 정보 삭제
	//집하 내역 삭제
	
}
