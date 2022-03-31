package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.sellerStore;

@Mapper
public interface MemberMapper {
	
	//사업장 목록 조회
	public List<sellerStore> sellerStoreInfo();
	
	//회원 목록 조회
	public List<Member> getMemberList(String searchKey, String searchValue);
	
	//회원 등록
	public int addMember(Member member);
	
}
