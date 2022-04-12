package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.DonorGoodsMapper;
import com.kfarmstar.dto.DonorGoods;

@Service
@Transactional
public class DonorGoodsService {
	
	private DonorGoodsMapper donorGoodsMapper;
	
	public DonorGoodsService(DonorGoodsMapper donorGoodsMapper) {
		
		this.donorGoodsMapper = donorGoodsMapper;
	}
	
	//기부 상품 목록
	public List<DonorGoods> getDonorGoodsList() {
		
		List<DonorGoods> donorGoodsList = donorGoodsMapper.getDonorGoodsList();
				
		return donorGoodsList;
	}
		
}
