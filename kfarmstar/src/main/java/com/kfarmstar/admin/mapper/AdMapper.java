package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.AdPrice;

@Mapper
public interface AdMapper {


	// 광고 단가 목록
	public List<AdPrice> getAdPriceList();
	
	// 광고 코드별 상세 정보 조회
	public AdPrice getAdPriceInfoByCode(String adPriceCode);
	
	// 광고 단가 수정
	public int modifyAdPrice(AdPrice adPrice);
	
	// 광고 단가 등록
	public int addAdPrice(AdPrice adPrice);

}
