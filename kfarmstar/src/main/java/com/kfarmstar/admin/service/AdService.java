package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.AdMapper;
import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.dto.AdPrice;

@Service
@Transactional
public class AdService {

	private AdMapper adMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public AdService(AdMapper adMapper, CommonMapper commonMapper) {
		this.adMapper = adMapper;
		this.commonMapper = commonMapper;
	}
	
	/**
	 * 광고 단가 목록 조회
	 */
	public List<AdPrice> getAdPriceList() {
		
		List<AdPrice> adPriceList = adMapper.getAdPriceList();
		return adPriceList;
	}
	

	/**
	 * 광고단가 코드별 정보 조회
	 */
	public AdPrice getAdPriceInfoByCode(String adPriceCode) {
		return adMapper.getAdPriceInfoByCode(adPriceCode);
	}
	
	
	/**
	 * 광고 단가 수정
	 */
	public int modifyAdPrice(AdPrice adPrice) {
		
		adPrice.setUpdateManagerId("id003"); //임의로 넣은 수정자 아이디
		return adMapper.modifyAdPrice(adPrice);
	}
	
	/**
	 * 광고 단가 등록
	 */
	public int addAdPrice(AdPrice adPrice) {
		//pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("ad_price_code", "ad_price");
		  adPrice.setAdPriceCode(newCode);
		  adPrice.setMemberId("id002"); //임의로 넣은 등록자 아이디
		  
		  int result = adMapper.addAdPrice(adPrice);
		  
		  return result; 
	}
	
	
}
