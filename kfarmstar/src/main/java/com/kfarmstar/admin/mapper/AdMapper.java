package com.kfarmstar.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.AdApply;
import com.kfarmstar.dto.AdPayType;
import com.kfarmstar.dto.AdPrice;
import com.kfarmstar.dto.AfterAdPay;
import com.kfarmstar.dto.BeforeAdPay;
import com.kfarmstar.dto.Grade;

@Mapper
public interface AdMapper {

	// 회원 아이디에 따른 등급별 혜택 조회
	public Grade getAdBenefitByGrade(String memberId);

	// 광고 신청 등록
	public int addAdApply(AdApply adApply);
	
	// 광고 진행 중 & 광고 완료 목록
	public List<AdApply> getAdvertisingList(Map<String, Object> paramMap);
	
	// 광고 신청 목록
	public List<AdApply> getAdApplyList(Map<String, Object> paramMap);
	
	// 광고 신청 코드별 상세 정보 조회
	public AdApply getAdApplyByCode(String adApplyCode);
	
	// 광고 신청 상세정보 수정
	public int modifyAdApply(AdApply adApply);
	
	// 광고 단가 목록
	public List<AdPrice> getAdPriceList();
	
	// 광고 가격 코드별 상세 정보 조회
	public AdPrice getAdPriceInfoByCode(String adPriceCode);
	
	// 광고 단가 수정
	public int modifyAdPrice(AdPrice adPrice);
	
	// 광고 단가 등록
	public int addAdPrice(AdPrice adPrice);
	
	
	// 진행상태 : (광고승인) 광고 결제전 처리
	public int adApproveUpdate(AdApply adApply);

	// 진행상태 : 광고 승인 취소
	public int adApproveCancle(AdApply adApply);
	
	// 진행상태 : 광고 결제완료 처리
	public int adPayComplete(AdApply adApply);
	
	// 광고 승인 후 결제 전 테이블에 정보 등록
	public int addBeforeAdPay(BeforeAdPay beforeAdPay);

	// 광고 결제 처리
	public int addAfterAdPay(AfterAdPay afterAdPay);
	
	// 광고 결제 종류 등록 처리
	public int addAdPayType(AdPayType adPayType);
	
	
	// 광고 신청번호에 따른 ad_payment_code 조회
	public String getPayCodeByApplyCode(String adApplyCode);

	// 광고 신청번호에 따른 결제후 정보 조회
	public AfterAdPay adPayDetailByApplyCode(String adApplyCode);
	

}
