package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kfarmstar.admin.mapper.ReviewMapper;
import com.kfarmstar.dto.Review;

@Service
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
	public List<Review> getreviewAdminList(){
		
		return reviewMapper.getreviewAdminList();
	}
	//구매자 상품평 목록
	public List<Review> getreviewList(){
		
		return reviewMapper.getreviewList();
	}

	

}
