package com.kfarmstar.admin.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfarmstar.admin.mapper.DeliveryMapper;
import com.kfarmstar.dto.CompanyEmployee;
import com.kfarmstar.dto.DeliveryCompany;
import com.kfarmstar.dto.DeliveryGoods;
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

		log.info("===== service getCompanyList 시작 =====");
		List<DeliveryCompany> companyList = deliveryMapper.getCompanyList();
		log.info("===== service getCompanyList 매퍼 값 받아오기 완료 =====");
		
		return companyList;
	}
	
	//회사 직원 목록 조회
	public List<CompanyEmployee> getEmployeeList() {
		
		log.info("===== service getEmployeeList 시작 =====");
		List<CompanyEmployee> employeeList = deliveryMapper.getEmployeeList();
		log.info("===== service getEmployeeList 매퍼 값 받아오기 완료 =====");
		
		return employeeList;
	}
	
	//운송장 목록 조회
	
	public List<DeliveryGoods> getDeliveryList() {
  
		log.info("===== service getDeliveryList 시작 =====");
		List<DeliveryGoods> deliveryList = deliveryMapper.getDeliveryList();
		log.info("===== service getDeliveryList 매퍼 값 받아오기 완료 =====");
  
		return deliveryList; 
	}
	
	
	//집하 목록 조회
	public List<DeliveryPickup> getPickupList() {

		log.info("===== service getPickupList 시작 =====");
		List<DeliveryPickup> pickupList = deliveryMapper.getPickupList();
		log.info("===== service getPickupList 매퍼 값 받아오기 완료 =====");
		
		return pickupList;
	}
	
	//배송 회사 내역 조회
	public DeliveryCompany getCompany(String companyCode) {
		
		DeliveryCompany codeGetCompany = deliveryMapper.getCompany(companyCode);
		
		if(codeGetCompany != null) {
			log.info("===== service getCompany 매퍼 값 받아오기 완료 =====");
			return codeGetCompany;
		}else {
			log.info("===== service getCompany 에러 =====");
			return null;
		}
	}
	
	
	//배송 운송장 내역 조회
	/*
	 * public DeliveryGoods getDelivery(String deliveryNum) {
	 * 
	 * DeliveryGoods numGetDelivery = deliveryMapper.getDelivery(deliveryNum);
	 * 
	 * if(numGetDelivery != null) {
	 * log.info("===== service getDelivery 매퍼 값 받아오기 완료 ====="); return
	 * numGetDelivery; }else { log.info("===== service getDelivery 에러 =====");
	 * return null; } }
	 */
	
	//배송 회사 정보 수정
	/*
	public List<DeliveryCompany> modifyCompany() {
		
		log.info("===== service modifyCompany 시작 =====");
		
		List<DeliveryCompany> modifyCompanyDetail = deliveryMapper.modifyCompany();
		
		log.info("===== service modifyCompany 매퍼 값 받아오기 완료 =====");
		
		return modifyCompanyDetail;
	}
	*/
	
	//회사 직원 정보 수정

	//운송장 내역 수정
	//집하 내역 수정
	
	//배송 회사 등록
	//회사 직원 등록
	//배송 등록
	public List<DeliveryGoods> addDeliveryCompany() {
		
		log.info("===== service addDeliveryCompany 시작 =====");
		List<DeliveryGoods> addDeliveryCompany = deliveryMapper.addDeliveryCompany();
		log.info("===== service addDeliveryCompany 매퍼 값 받아오기 완료 =====");
		
		return addDeliveryCompany;
	}
	public List<DeliveryGoods> addDeliveryGoods() {
		
		log.info("===== service addDeliveryGoods 시작 =====");
		List<DeliveryGoods> addDeliveryGoods = deliveryMapper.addDeliveryGoods();
		log.info("===== service addDeliveryGoods 매퍼 값 받아오기 완료 =====");
		
		return addDeliveryGoods;
	}
	public void addDelivery(DeliveryGoods deliveryGoods) {
		
		log.info("===== service addDeliveryGoods 시작 =====");
		deliveryMapper.addDelivery(deliveryGoods);
		log.info("===== service addDeliveryGoods 매퍼 값 받아오기 완료 =====");
	}
	public DeliveryCompany getCompanyByCompanyCode(String companyCode) {
		
		log.info("===== service getCompanyByCompanyCode 시작 =====");
		DeliveryCompany getDelivery = deliveryMapper.getCompanyByCompanyCode(companyCode);
		log.info("===== service getCompanyByCompanyCode 매퍼 값 받아오기 완료 =====");
		
		return getDelivery;
	}
	
	//집하 등록
	
	//배송 회사 삭제
	//회사 직원 삭제
	//운송장 정보 삭제
	//집하 내역 삭제
	
}
