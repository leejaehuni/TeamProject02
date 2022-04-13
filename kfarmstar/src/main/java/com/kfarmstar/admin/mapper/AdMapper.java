package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.AdApply;
import com.kfarmstar.dto.AdPrice;
import com.kfarmstar.dto.Grade;

@Mapper
public interface AdMapper {

	// 회원 아이디에 따른 등급별 혜택 조회
	public Grade getAdBenefitByGrade(String memberId);

	// 광고 신청 등록
	public int addAdApply(AdApply adApply);
	
	// 광고 진행 중 or 광고 완료 목록
	public List<AdApply> getAdvertisingList();
	
	// 광고 신청 목록
	public List<AdApply> getAdApplyList();
	
	// 광고 신청 코드별 상세 정보 조회
	public AdApply getAdApplyByCode(String adApplyCode);
	
	// 광고 신청 상세정보 수정
	public int modifyAdApply(AdApply adApply);
	
	// 광고 단가 목록
	public List<AdPrice> getAdPriceList();
	
	// 광고 코드별 상세 정보 조회
	public AdPrice getAdPriceInfoByCode(String adPriceCode);
	
	// 광고 단가 수정
	public int modifyAdPrice(AdPrice adPrice);
	
	// 광고 단가 등록
	public int addAdPrice(AdPrice adPrice);
	
	// 광고 승인 
	public int adApproveUpdate(AdApply adApply);

	// 광고 승인 취소
	public int adApproveCancle(AdApply adApply);
	

}
