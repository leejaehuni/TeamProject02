package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;

@Mapper
public interface MemberMapper {
	
	//등급번호별 판매자 혜택 정보 조회
	public SellerGrade getSellerStandardByNum(String sellerGradeNum);
	
	//판매자 기준 및 혜택 정보 수정
	public int modifySellerGrade(SellerGrade sellerGrade);
	
	//판매자 기준 및 혜택 정보 조회
	public List<SellerGrade> sellerStandard();
	
	//datepicker 기간 조회
	public List<Member> searchDate(String searchKey, String searchValue);
	
	//사업장 목록 조회
	public List<SellerStore> sellerStoreInfo();
	
	//회원 목록 조회
	public List<Member> getMemberList(String searchKey, String searchValue);
	
	//회원 등록
	public int addMember(Member member);
	
	//회원 아이디 중복 체크
	public boolean isIdCheck(String memberId);
	
}
