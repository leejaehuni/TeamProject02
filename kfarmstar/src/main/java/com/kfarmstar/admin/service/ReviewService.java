package com.kfarmstar.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.ReviewMapper;
import com.kfarmstar.dto.Review;

@Service
@Transactional
public class ReviewService {
	
	private ReviewMapper reviewMapper;
	
	public ReviewService(ReviewMapper reviewMapper) {
		
		this.reviewMapper = reviewMapper;
	}
	
	//상품평 수정
	public int modifyReview(Review review) {
		return reviewMapper.modifyReview(review);
	}
	
	//상품평 등록
	public int addReview(Review review) {
	int result = reviewMapper.addReview(review);
	
		return result;
	}
	
	//관리자 상품평 목록
	public List<Review> getReviewAdminList(){
		
		List<Review> reviewAdminList = reviewMapper.getReviewAdminList();
		
		return reviewAdminList;
	}
	//구매자 상품평 목록
	public List<Review> getReviewList(Map<String, String> paramMap){
		
		List<Review> getreviewAdminList = reviewMapper.getReviewList(paramMap);
		
		return getreviewAdminList;
	}


	

}
