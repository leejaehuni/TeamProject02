package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.ReviewMapper;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.Review;

@Service
@Transactional
public class ReviewService {
	
	private ReviewMapper reviewMapper;
	
	public ReviewService(ReviewMapper reviewMapper) {
		
		this.reviewMapper = reviewMapper;
	}
	//패스워드 체크
	public Member passwordCheck(String memberPw) {
		return reviewMapper.passwordCheck(memberPw);
	}
	
	//상품평 수정
	public int modifyReview() {
		return reviewMapper.modifyReview();
	}
	
	//상품평 등록
	public int addReview(Review review) {
		int result = reviewMapper.addReview(review);
	
		return result;
	}
	
	//상품평 목록
	public List<Review> getReviewAdminList(){
		
		List<Review> reviewAdminList = reviewMapper.getReviewAdminList();
		
		return reviewAdminList;
	}
	

}
