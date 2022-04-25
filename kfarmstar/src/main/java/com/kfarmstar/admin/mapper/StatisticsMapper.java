package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Statistics;

@Mapper
public interface StatisticsMapper {
	
	//날짜별 상품통계 목록 조회
		public List<Statistics> getGoodsStatisticsList(String startDate, String endDate);
	//상품별 통계 조회
		public List<Statistics> goodsTypeStatisticsList(String goodsSmallCate);
}
