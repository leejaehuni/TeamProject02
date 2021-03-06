package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.MemberMapper;
import com.kfarmstar.dto.LoginHistory;
import com.kfarmstar.dto.LogoutHistory;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;
/*깃허브수정*/

@Service
@Transactional
public class MemberService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	// 회원 권한별 회원목록 조회
	public List<Member> searchLevelMemberList(String memberLevel){
		
		List<Member> searchLevelMemberList = memberMapper.searchLevelMemberList(memberLevel);
		
		return searchLevelMemberList;
	}
	
	// 사업장 등록날짜별 사업장 목록 조회
	public List<SellerStore> searchDateSellerList(String startDate, String endDate){
		
		List<SellerStore> searchDateSellerList = memberMapper.searchDateSellerList(startDate, endDate);
		
		return searchDateSellerList;
	}
	
	// 가입날짜별 회원목록 조회
	public List<Member> searchDateMemberList(String startDate, String endDate){
		
		List<Member> searchDateMemberList = memberMapper.searchDateMemberList(startDate, endDate);
		
		return searchDateMemberList;
	}
	
	public List<Member> allSearchMemberList(String startDate, String endDate, String searchKey, String searchValue){
		
		 List<Member> allSearchMemberList = memberMapper.allSearchMemberList(startDate, endDate, searchKey, searchValue);
		 
		 return allSearchMemberList;
	}
	
	public List<LogoutHistory> getLogoutHistory(){
		
		List<LogoutHistory> getLogoutHistoryList = memberMapper.getLogoutHistory();
		
		return getLogoutHistoryList;
	}
	
	public List<LoginHistory> getLoginHistory(){
		
		List<LoginHistory> getLoginHistoryList = memberMapper.getLoginHistory();
		
		return getLoginHistoryList;
		
	}
	
	// 검색조건별 판매자 사업장 목록 조회
	public List<SellerStore> conditionSellerStoreList(String searchKey, String searchValue){
		
		List<SellerStore> conditionSellerStoreList = memberMapper.conditionSellerStoreList(searchKey, searchValue);
		
		return conditionSellerStoreList;
	}
	
	// 검색조건별 회원 목록 조회
	public List<Member> conditionMemberList(String searchKey, String searchValue){
		
		List<Member> conditionMemberList = memberMapper.conditionMemberList(searchKey, searchValue);
		
		return conditionMemberList;
	}
	
	//판매자 사업장 정보 수정
	public int modifySellerStore(SellerStore sellerStore) {
		
		return memberMapper.modifySellerStore(sellerStore);
	}
	
	
	
	// 판매자 사업장 상세 조회
	public SellerStore getSellStoreInfo(String sellerStoreNum) {
		
		return memberMapper.getSellStoreInfo(sellerStoreNum);
	}
	
	// 회원상세내역 회원정보 수정
	public int modifyMember(Member member) {
		
		System.out.println("회원수정 service" + member);
		
		return memberMapper.modifyMember(member);
	}
	
	// 회원 아이디에 맞는 회원상세정보 조회
	public Member getMemberInfoById(String memberId) {
		
		System.out.println("회원상세정보 service" + memberId);
		
		return memberMapper.getMemberInfoById(memberId);
	}
	
	// 기준번호에 맞는 판매자 기준 정보 조회
	public SellerGrade getSellerStandardByNum(String sellerGradeNum) {
		
		return memberMapper.getSellerStandardByNum(sellerGradeNum);
	}
	
	// 판매자 기준 및 혜택 정보 수정
	public int modifySellerGrade(SellerGrade sellerGrade) {
		
		return memberMapper.modifySellerGrade(sellerGrade);
	}
	
	// 판매자 등급 기준 및 혜택 조회
	public List<SellerGrade> sellerStandard(){
		
		List<SellerGrade> sellerGradeList = memberMapper.sellerStandard();
		
		return sellerGradeList;
	}
	
	public List<Member> searchDate(String searchKey, String searchValue){
		
		List<Member> searchDate = memberMapper.searchDate(searchKey, searchValue);
		
		return searchDate;
	}
	
	// 판매자 사업장 목록 조회
	public List<SellerStore> sellerStoreInfo(){
		
		List<SellerStore> sellerStoreList = memberMapper.sellerStoreInfo();
		System.out.println(sellerStoreList.get(0).getSellerStoreNum()+"<- sellerStoreList.get(0).getSellerStoreNum() sellerStoreInfo MemberService.java");
		
		return sellerStoreList;
	}
	
	// 회원 목록 조회
	public List<Member> getMemberList(String searchKey, String searchValue) {
		
		List<Member> memberList = memberMapper.getMemberList(searchKey, searchValue);
		
		return memberList;
	}
	
	// 관리자 회원 등록
	public int addMember(Member member) {
		
		member.setMemberLevel("관리자");
		member.setMemberPoint(0);
		
		int addMember = memberMapper.addMember(member);
		
		System.out.println(addMember + "<- addMember");
		return addMember;
	}
}
