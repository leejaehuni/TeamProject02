package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.DonorGoodsMapper;
import com.kfarmstar.dto.DonationGoods;

@Service
@Transactional
public class DonorGoodsService {
	
	private DonorGoodsMapper donorGoodsMapper;
	
	public DonorGoodsService(DonorGoodsMapper donorGoodsMapper) {
		
		this.donorGoodsMapper = donorGoodsMapper;
	}
	
	/**
	 * 기부 상품 삭제
	 */
	 public int removeGoods(DonationGoods donationGoods, int donationBoardCode) {
		int result = donorGoodsMapper.removeDonorGoods(donationBoardCode);
		
		 return result;
	 }
	
	/**
	 * 기부 상품 수정
	 */
	public int modifyDonorGoods(DonationGoods donationGoods) {
		return donorGoodsMapper.modifyDonorGoods(donationGoods);
	}
	
	/**
	 * 기부 상품 등록
	 */
	public void addDonorGoods(DonationGoods donationGoods, String donorGoodsId) {
		donorGoodsMapper.addDonorGoods(donationGoods, donorGoodsId);
	}
		
	
	/**
	 * 기부 상품 목록
	 */
	public List<DonationGoods> getDonorGoodsList() {
		
		List<DonationGoods> donorGoodsList = donorGoodsMapper.getDonorGoodsList();
				
		return donorGoodsList;
	}

		
}
