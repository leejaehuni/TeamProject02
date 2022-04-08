package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;


@Mapper
public interface GoodsMapper {
	
	
	// 상품 등록
	public int addGoods(Goods goods);
	
	// 상품 코드별 상세 정보 조회
	public Goods getGoodsByCode(String goodsRefurbCode);
	
	// 상품 전체 목록 조회
	public List<Goods> getGoodsList();
	
	// 상품 카테고리 전체 목록 조회
	public List<GoodsSmall> getGoodsCateList();

	// 상품 대분류 카테고리 등록
	public int addLargeCate(GoodsLarge goodsLarge);
		
	// 상품 소분류 카테고리 등록
	public int addSmallCate(GoodsSmall goodsSmall);
	
	// 상품 소분류 카테고리  수정
	public int modifyGoodsCate(GoodsSmall goodsSmall);
	
	// 상품 대분류 카테고리 목록 조회
	public List<GoodsLarge> getLargeCateList();
	
	// 소분류 코드별 정보 조회
	public GoodsSmall getSmallCateInfoByCode(String goodsSmallCate);

	
}
