package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.DonorPlaceMapper;
import com.kfarmstar.dto.DonationApply;
import com.kfarmstar.dto.DonationPlace;
import com.kfarmstar.dto.Member;

@Service
@Transactional
public class DonorPlaceService {
	
	private DonorPlaceMapper donorPlaceMapper;
	
	public DonorPlaceService(DonorPlaceMapper donorPlaceMapper) {
		
		this.donorPlaceMapper = donorPlaceMapper;
	}
	
	/**
	 * 기부 상품 사용처 등록 심사
	 */
	public List<DonationApply> confirmDonorPlace(DonationApply donationApply) {
		
		List<DonationApply> donorApplyConfirm = donorPlaceMapper.confirmDonorPlace(donationApply);
		
		return donorApplyConfirm;
	}
	
	/**
	 * 기부 상품 사용처 등록 신청
	 */
	public void applyDonorPlace(DonationApply donationApply) {
		donorPlaceMapper.applyDonorPlace(donationApply);
	}
	/**
	 * 기부 사용처 등록
	 */
	public void addDonorPlace(DonationPlace donationPlace, String donorPlaceId) {
		donorPlaceMapper.addDonorPlace(donationPlace, donorPlaceId);
	}
	/**
	 * 기부 사용처 목록
	 */
	public Member passwordCheck(String memberPw) {
		return donorPlaceMapper.passwordCheck(memberPw);
	}
	
	/**
	 * 기부 사용처 목록
	 */
	public List<DonationPlace> getDonorPlaceList(){
		
		List<DonationPlace> donorPlaceList = donorPlaceMapper.getDonorPlaceList();
		
		return donorPlaceList;
	}
}
