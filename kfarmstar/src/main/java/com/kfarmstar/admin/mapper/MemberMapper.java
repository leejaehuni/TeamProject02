package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;

@Mapper
public interface MemberMapper {
	
	
	
	//조건별 판매자 사업장 조회
	public List<SellerStore> conditionSellerStoreList(String searchKey, String searchValue);
	
	//조건별 회원 조회
	public List<Member> conditionMemberList(String searchKey, String searchValue);
	
	//판매자 사업장 정보 수정
	public int modifySellerStore(SellerStore sellerStore);
	
	//사업장 번호별 판매자 사업장 상세 정보 조회
	public SellerStore getSellStoreInfo(String sellerStoreNum);
	
	//회원 정보 수정
	public int modifyMember(Member member);
	
	//회원별 상세내역 조회
	public Member getMemberInfoById(String memberId);
	
	//등급번호별 판매자 혜택 및 기준 정보 조회
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
