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


@Service
@Transactional
public class MemberService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public List<SellerStore> searchDateSellerList(String startDate, String endDate){
		
		List<SellerStore> searchDateSellerList = memberMapper.searchDateSellerList(startDate, endDate);
		
		return searchDateSellerList;
	}
	
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
	
	public List<SellerStore> conditionSellerStoreList(String searchKey, String searchValue){
		
		List<SellerStore> conditionSellerStoreList = memberMapper.conditionSellerStoreList(searchKey, searchValue);
		
		return conditionSellerStoreList;
	}
	
	public List<Member> conditionMemberList(String searchKey, String searchValue){
		
		List<Member> conditionMemberList = memberMapper.conditionMemberList(searchKey, searchValue);
		
		return conditionMemberList;
	}
	
	public int modifySellerStore(SellerStore sellerStore) {
		
		return memberMapper.modifySellerStore(sellerStore);
	}
	
	public SellerStore getSellStoreInfo(String sellerStoreNum) {
		
		return memberMapper.getSellStoreInfo(sellerStoreNum);
	}
	
	public int modifyMember(Member member) {
		
		System.out.println("회원수정 service" + member);
		
		return memberMapper.modifyMember(member);
	}
	
	public Member getMemberInfoById(String memberId) {
		
		System.out.println("회원상세정보 service" + memberId);
		
		return memberMapper.getMemberInfoById(memberId);
	}
	
	public SellerGrade getSellerStandardByNum(String sellerGradeNum) {
		
		return memberMapper.getSellerStandardByNum(sellerGradeNum);
	}
	
	public int modifySellerGrade(SellerGrade sellerGrade) {
		
		return memberMapper.modifySellerGrade(sellerGrade);
	}
	
	public List<SellerGrade> sellerStandard(){
		
		List<SellerGrade> sellerGradeList = memberMapper.sellerStandard();
		
		return sellerGradeList;
	}
	
	public List<Member> searchDate(String searchKey, String searchValue){
		
		List<Member> searchDate = memberMapper.searchDate(searchKey, searchValue);
		
		return searchDate;
	}
	
	public List<SellerStore> sellerStoreInfo(){
		
		List<SellerStore> sellerStoreList = memberMapper.sellerStoreInfo();
		System.out.println(sellerStoreList.get(0).getSellerStoreNum()+"<- sellerStoreList.get(0).getSellerStoreNum() sellerStoreInfo MemberService.java");
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		//Map<String, Object> resultMap = (List<sellerStore>)memberMapper.sellerStoreInfo();
		//resultMap.put("sellerStorelist", sellerStoreList);
		
		return sellerStoreList;
	}
	
	public List<Member> getMemberList(String searchKey, String searchValue) {
		
		List<Member> memberList = memberMapper.getMemberList(searchKey, searchValue);
		
		return memberList;
	}
	
	public int addMember(Member member) {
		
		member.setMemberLevel("관리자");
		member.setMemberPoint(0);
		
		int addMember = memberMapper.addMember(member);
		
		System.out.println(addMember + "<- addMember");
		return addMember;
	}
}
