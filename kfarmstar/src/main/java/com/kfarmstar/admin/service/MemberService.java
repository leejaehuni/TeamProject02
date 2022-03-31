package com.kfarmstar.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.MemberMapper;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.sellerStore;


@Service
@Transactional
public class MemberService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public List<sellerStore> sellerStoreInfo(){
		
		List<sellerStore> sellerStoreList = memberMapper.sellerStoreInfo();
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
