package com.kfarmstar.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.admin.mapper.MemberMapper;
import com.kfarmstar.admin.service.MemberService;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.sellerStore;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private MemberService memberService;
	private MemberMapper memberMapper;
	
	public MemberController(MemberService memberService, MemberMapper memberMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 관리자 등록");
		model.addAttribute("titleName", "관리자 등록");
		
		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		log.info("회원가입폼 시작");
		
		memberService.addMember(member);
		
		log.info("회원가입폼에서 입력받은 데이터:{}", member);
		
		return "redirect:/member/memberList";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model
							,@RequestParam(value="searchKey", required = false) String searchKey
							,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("회원목록 요청");
		log.info("searchValue:{}", searchValue);
		
		List<Member> memberList = memberService.getMemberList(searchKey, searchValue);
		
		model.addAttribute("title", "FoodRefurb : 회원 목록");
		model.addAttribute("titleName", "회원 관리");
		model.addAttribute("memberList", memberList);
		
		
		return "member/memberList";
	}
	
	
	@GetMapping("/modifyMember")
	public String modifyMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 수정");
		model.addAttribute("titleName", "회원 정보 수정");
		
		
		return "member/modifyMember";
	}
	
	@GetMapping("/removeMember")
	public String removeMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 삭제");
		model.addAttribute("titleName", "회원 삭제");
		
		return "member/removeMember";
	}
	
	@GetMapping("/detailMember")
	public String getDetailMemberInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 정보");
		model.addAttribute("titleName", "회원 상세정보");
		
		return "member/detailMember";
	}
	
	@GetMapping("/loginList")
	public String loginMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 로그인");
		model.addAttribute("titleName", "회원 로그인 내역");
		
		return "member/loginList";
	}
	
	@GetMapping("/logoutList")
	public String logoutMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 로그아웃");
		model.addAttribute("titleName", "회원 로그아웃 내역");
		
		return "member/logoutList";
	}
	
	@GetMapping("/sellerGrade")
	public String sellerGrade(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 등급");
		model.addAttribute("titleName", "회원 등급 혜택 및 기준");
		
		return "member/sellerGrade";
	}
	
	@GetMapping("/modifySellerGradeCriteria")
	public String modifySellerGrade(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 수정");
		model.addAttribute("titleName", "등급 기준 수정");
		
		return "member/modifySellerGradeCriteria";
	}
	
	@GetMapping("/modifySellerGradeBenefit")
	public String modifySellerGradeBenefit(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 혜택 수정");
		model.addAttribute("titleName", "등급 혜택 수정");
		
		return "member/modifySellerGradeBenefit";
	}
	
	@GetMapping("/removeSellerGradeCriteria")
	public String removeSellerGraderemoveSellerGradeCriteria(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 삭제");
		model.addAttribute("titleName", "등급 기준 삭제");
		
		return "member/removeSellerGradeCriteria";
	}
	
	@GetMapping("/removeSellerGradeBenefit")
	public String removeSellerGradeBenefit(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 혜택 삭제");
		model.addAttribute("titleName", "등급 혜택 삭제");
		
		return "member/removeSellerGradeBenefit";
	}
	
	@GetMapping("/sellerStoreInfo")
	public String sellerStoreInfo(Model model) {
		
		
		List<sellerStore> sellerStoreList = memberService.sellerStoreInfo();
		
		//List<sellerStore> sellerStoreList = (List<sellerStore>) resultMap.get("sellerStoreList");
		
		log.info("사업장 목록: {}", sellerStoreList);
		
		model.addAttribute("title", "FoodRefurb : 사업장 관리");
		model.addAttribute("titleName", "판매자 사업장 관리");
		model.addAttribute("sellerStoreList", sellerStoreList);
		
		return "member/sellerStoreInfo";
	}
	
	@GetMapping("/modifySellerStoreInfo")
	public String modifySellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 수정");
		model.addAttribute("titleName", "사업장 정보 수정");
		
		return "member/modifySellerStoreInfo";
	}
	
	@GetMapping("/removeSellerStoreInfo")
	public String removeSellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 삭제");
		model.addAttribute("titleName", "사업장 정보 삭제");
		
		return "member/removeSellerStoreInfo";
	}
	
	@GetMapping("/detailSellerStoreInfo")
	public String detailSellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 정보");
		model.addAttribute("titleName", "사업장 상세정보");
		
		return "member/detailSellerStoreInfo";
	}
}
