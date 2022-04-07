package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Review;

@Mapper
public interface ReviewMapper {
	
	//상품평 수정
	public int modifyReview(Review review);
	
	//상품평 등록
	public int addReview(Review review);
	
	//관리자 상품평 목록
	public List<Review> getreviewAdminList();
	
	//구매자 상품평 목록
	public List<Review> getreviewList();

}
