package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.DonationGoods;


@Mapper
public interface DonorGoodsMapper {
	
	/**
	 * 기부 상품 삭제
	 */
	public int removeDonorGoods(int donationBoardCode);
	
	/**
	 * 기부 상품 수정
	 */
	public int modifyDonorGoods(DonationGoods donationGoods);
	
	/**
	 * 기부 상품 등록
	 */
	public int addDonorGoods(DonationGoods donationGoods, String donorGoodsId);
	
	/**
	 * 기부 상품 목록
	 */
	public List<DonationGoods> getDonorGoodsList();
}
