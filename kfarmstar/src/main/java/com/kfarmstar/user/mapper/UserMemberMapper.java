package com.kfarmstar.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Grade;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;
@Mapper
public interface UserMemberMapper {
	
	//마이페이지 판매자 정보 수정
	public int modifySellerStore(SellerStore sellerStore);
	
	//마이페이지 회원 정보 수정
	public int modifyMember(Member member);
	
	//마이페이지 판매자 사업장 조회
	public SellerStore getSellStoreInfo(String memberId);
	
	// 판매자 등급 부여
	public int addSellerGrade(Grade grade);
	
	// 판매자 회원가입
	public int addSellerStoreInfo(SellerStore sellerStore);
	
	//아이디별 회원정보 조회
	public Member getMemberInfoById(String memberId);
	
	//구매자 회원가입
	public int addMember(Member member);
	
	//아이디 중복 체크
	public boolean isIdCheck(String memberId);
}
