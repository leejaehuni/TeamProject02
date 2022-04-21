package com.kfarmstar.admin.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.CompanyEmployee;
import com.kfarmstar.dto.DeliveryCompany;
import com.kfarmstar.dto.DeliveryGoods;
import com.kfarmstar.dto.DeliveryPickup;

@Mapper
public interface DeliveryMapper {
	
	//배송 회사 목록 조회
	public List<DeliveryCompany> getCompanyList();

	//회사 직원 목록 조회
	public List<CompanyEmployee> getEmployeeList();
	
	//운송장 목록 조회
	public List<DeliveryGoods> getDeliveryList();
	
	//집하 목록 조회
	public List<DeliveryPickup> getPickupList();
	
	//배송 회사 내역 조회
	public DeliveryCompany getCompany(String companyCode);
	
	//배송 운송장 내역 조회
	public DeliveryGoods getDelivery(String deliveryNum);
	
	//배송 회사 내역 수정
	//public List<DeliveryCompany> modifyCompany();
	
	//회사 직원 내역 수정
	//운송장 내역 수정
	//집하 내역 수정
	
	//배송 회사 등록
	//회사 직원 등록
	//배송 등록
	public List<DeliveryGoods> addDeliveryCompany();
	public List<DeliveryGoods> addDeliveryGoods();
	public int addDelivery(DeliveryGoods deliveryGoods);
	public List<DeliveryCompany> changeDelivery();
	
	//집하 등록
	
	//배송 회사 삭제
	//회사 직원 삭제
	//운송장 정보 삭제
	//집하 내역 삭제
	
}
