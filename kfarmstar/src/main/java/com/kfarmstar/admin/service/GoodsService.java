package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;


@Service
@Transactional
public class GoodsService {

	//DI 의존성 주입
	private GoodsMapper goodsMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public GoodsService(GoodsMapper goodsMapper, CommonMapper commonMapper) {
		this.goodsMapper = goodsMapper;
		this.commonMapper = commonMapper;
	}
	
	
	// 상품 코드별 상세 정보 조회
	public Goods getGoodsByCode(String goodsRefurbCode) {
		
		return goodsMapper.getGoodsByCode(goodsRefurbCode);
	}
	
	
	// 전체 상품 목록 조회
	public List<Goods> getGoodsList() {
		List<Goods> goodsList = goodsMapper.getGoodsList();
		return goodsList;
	}
	
	
	// 전체 상품 카테고리 목록 조회
	public List<GoodsSmall> getGoodsCateList() {
		List<GoodsSmall> goodsCateList = goodsMapper.getGoodsCateList();
		return goodsCateList;
	}
	 
	
	// 상품 대분류 카테고리 목록 조회
	public List<GoodsLarge> getLargeCateList() {
		List<GoodsLarge> largeCateList = goodsMapper.getLargeCateList();
		return largeCateList;
	}
	
	// 상품 대분류 카테고리 등록
	public int addLargeCate(GoodsLarge goodsLarge) {
		 //pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("goods_large_cate", "goods_large");
		  goodsLarge.setGoodsLargeCate(newCode); 
		  goodsLarge.setMemberId("id002"); //임의로 넣은 등록자 아이디
		  
		  int result = goodsMapper.addLargeCate(goodsLarge);
		  
		  return result; 
	}
	
	public int modifyGoodsCate(GoodsSmall goodsSmall) {
			
		return goodsMapper.modifyGoodsCate(goodsSmall);
	}
	
	public int addSmallCate(GoodsSmall goodsSmall) {
		String newCode = commonMapper.getNewCode("goods_small_cate", "goods_small");
		goodsSmall.setGoodsSmallCate(newCode);
		goodsSmall.setMemberId("id002"); //임의로 넣은 등록자 아이디

		int result = goodsMapper.addSmallCate(goodsSmall);
		
		return result;
	}

	public GoodsSmall getSmallCateInfoByCode(String goodsSmallCate) {
		return goodsMapper.getSmallCateInfoByCode(goodsSmallCate);
	}
}
