package com.kfarmstar.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfarmstar.admin.mapper.InquiryMapper;

@Service
public class InquiryService {
	
	//DI 의존성 주입
	private InquiryMapper inquiryMapper;
	
	@Autowired
	public InquiryService(InquiryMapper inquiryMapper) {
		this.inquiryMapper = inquiryMapper;
	}
	
	/* 카테고리 목록 조회 */
	/* 문의 목록 조회 */
	
	/* 문의 내역 등록 */
	/* 문의 답변 내역 등록 */
	
	/* 문의 내역 수정 */
	/* 문의 답변 내역 수정 */
	
	/* 문의 내역 삭제 */
	/* 문의 답변 내역 삭제 */
}
