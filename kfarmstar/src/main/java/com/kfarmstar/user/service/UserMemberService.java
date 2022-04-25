package com.kfarmstar.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.FileMapper;
import com.kfarmstar.dto.FileDto;
import com.kfarmstar.dto.Grade;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.user.mapper.UserMemberMapper;
import com.kfarmstar.util.FileUtil;
@Service
@Transactional
public class UserMemberService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private UserMemberMapper userMemberMapper;
	private CommonMapper commonMapper;
	private FileUtil fileUtil;
	private FileMapper fileMapper;
	
	@Autowired
	public UserMemberService(UserMemberMapper userMemberMapper, CommonMapper commonMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.userMemberMapper = userMemberMapper;
		this.commonMapper = commonMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	public int modifySellerStore(SellerStore sellerStore) {
		
		return userMemberMapper.modifySellerStore(sellerStore);
	}
	
	public int modifyMember(Member member) {
		
		return userMemberMapper.modifyMember(member);
	}
	
	public SellerStore getSellStoreInfo(String memberId) {
		
		return userMemberMapper.getSellStoreInfo(memberId);
	}
	
	// 판매자 회원가입 시 사업장 자동 증가 번호 및 권한 부여
	public int addSellerStoreInfo(SellerStore sellerStore, Member member, Grade grade, MultipartFile[] fileImage, String fileRealPath) {
		
		String newCode = commonMapper.getNewCode("seller_store_num", "seller_store");
		String newCode2 = commonMapper.getNewCode("seller_id_grade", "seller_grade");
		
		sellerStore.setSellerStoreNum(newCode);
		grade.setSellerIdGrade(newCode2);
		
		member.setMemberLevel("판매자");
		grade.setSellerGradeNum("seller_grade_num_1");
		grade.setSellerGradeType("씨앗");
		
		List<FileDto> fileList = fileUtil.parseFileInfo(fileImage, fileRealPath);
		
		fileMapper.addFiles(fileList);
		
		List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
		
		Map<String, String> paramMap = null;
		
		for(FileDto fileDto : fileList) {
			paramMap = new HashMap<String,String>();
			paramMap.put("referenceCode", newCode);
			paramMap.put("fileIdx", fileDto.getFileIdx());
			paramList.add(paramMap);
		}
		
		fileMapper.addFilesContol(paramList);
		
		int result = userMemberMapper.addMember(member);
		sellerStore.setMemberId(member.getMemberId());
		grade.setMemberId(member.getMemberId());
		
		result += userMemberMapper.addSellerStoreInfo(sellerStore);
		result += userMemberMapper.addSellerGrade(grade);
		
		return result;
	}
	
	public Member getMemberInfoById(String memberId) {
		return userMemberMapper.getMemberInfoById(memberId);
	}
	
	// 구매자 권한 회원가입
	public int addMember(Member member) {
		
		member.setMemberLevel("구매자");
		member.setMemberPoint(0);
		
		int addMember = userMemberMapper.addMember(member);
		
		return addMember;
		
	}
	
}
