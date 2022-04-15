package com.kfarmstar.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.StatisticsMapper;
import com.kfarmstar.dto.Statistics;

@Service
@Transactional
public class StatisticsService {
private static final Logger log = LoggerFactory.getLogger(NoticeBoardService.class);

	
	private StatisticsMapper statisticsMapper;
	
	public StatisticsService(StatisticsMapper statisticsMapper) {
		this.statisticsMapper = statisticsMapper;
	}
	
	//공지 목록 조회
	public List<Statistics> getGoodsStatisticsList() {
		System.out.println("getGoodsStatisticsList StatisticsService.java");

		List<Statistics> goodsStatisticsList = statisticsMapper.getGoodsStatisticsList();
		System.out.println(goodsStatisticsList+"<-- GoodsStatisticsList getGoodsStatisticsList NoticeBoardService.java");
			
		return goodsStatisticsList;
	}
		
		
		
		
		
		
}