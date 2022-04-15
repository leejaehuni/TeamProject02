package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Statistics;

@Mapper
public interface StatisticsMapper {
	
	//상품통계 목록 조회

	public List<Statistics> getGoodsStatisticsList();

}
