package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.DonationApply;
import com.kfarmstar.dto.DonationPlace;
import com.kfarmstar.dto.Member;

@Mapper
public interface DonorPlaceMapper {
	
	
	/**
	 * 패스워드 체크
	 */
	public Member passwordCheck(String memberPw);
	
	/**
	 * 기부 상품 사용처 등록 심사
	 */
	public List<DonationApply> confirmDonorPlace(DonationApply donationApply);
	/**
	 * 기부 상품 사용처 등록 신청
	 */
	public int applyDonorPlace(DonationApply donationApply);
	
	/**
	 * 기부 사용처 등록
	 */
	public int addDonorPlace(DonationPlace donationPlace, String donorPlaceId);
	/**
	 * 기부 사용처 목록
	 */
	public List<DonationPlace> getDonorPlaceList();
}
