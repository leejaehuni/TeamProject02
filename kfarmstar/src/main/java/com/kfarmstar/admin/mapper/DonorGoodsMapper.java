package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.DonorGoods;



@Mapper
public interface DonorGoodsMapper {
	
	//기부상품 목록
	public List<DonorGoods> getDonorGoodsList();
}
