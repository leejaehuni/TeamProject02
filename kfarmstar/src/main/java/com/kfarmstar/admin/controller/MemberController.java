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
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfarmstar.admin.mapper.MemberMapper;
import com.kfarmstar.admin.service.MemberService;
import com.kfarmstar.dto.LoginHistory;
import com.kfarmstar.dto.LogoutHistory;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerGrade;
import com.kfarmstar.dto.SellerStore;

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
	
	// 아이디 중복체크 여부
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) {
		boolean idCheck = false;
		log.info("아이디중복체크 클릭시 요청받은 memberId의 값: {}", memberId);
		
		boolean result = memberMapper.isIdCheck(memberId);
		if(result) idCheck = true;
		
		log.info("아이디중복체크 여부 : {}", result);
		return idCheck;
	}
	
	// 관리자 회원 등록
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 관리자 등록");
		model.addAttribute("titleName", "관리자 등록");
		
		return "member/addMember";
	}
	
	// 관리자 회원 등록
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		log.info("회원가입폼 시작");
		
		memberService.addMember(member);
		
		log.info("회원가입폼에서 입력받은 데이터:{}", member);
		
		return "redirect:/member/memberList";
	}
	
	//회원 목록 조회
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
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-15
	 * 검색 조건에 맞는 판매자 사업장 목록 조회
	 * */
	@GetMapping("/conditionSellerStoreList")
	public String conditionSellerStoreList(Model model
											,@RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("조건별 판매자 사업장 검색:{}", searchValue);
		
		List<SellerStore> conditionSellerStoreList = memberService.conditionSellerStoreList(searchKey, searchValue);
		
		model.addAttribute("sellerStoreList", conditionSellerStoreList);
		
		return "member/sellerStoreInfo";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-14
	 * 검색 조건에 맞는 회원 목록 조회
	 * */
	@GetMapping("/conditionMemberList")
	public String conditionMemberList(Model model
											,@RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("조건별 회원 검색:{}", searchValue);
		
		List<Member> conditionMemberList = memberService.conditionMemberList(searchKey, searchValue);
		
		model.addAttribute("memberList", conditionMemberList);
		
		return "member/memberList";
	}
	
	
	
	@PostMapping("/allSearchMemberList")
	public String allSearchMemberList(Model model
								  	,@RequestParam(value="startDate", required = false) String startDate
									,@RequestParam(value="endDate", required = false) String endDate
									,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
									,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
	  
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		log.info("가입기간별 회원 검색:{}", searchKey);
		log.info("가입기간별 회원 검색:{}", searchValue);
		 
		List<Member> allSearchMemberList = memberService.allSearchMemberList(startDate, endDate, searchKey, searchValue);
		 
		
		model.addAttribute("memberList", allSearchMemberList);
		  
		return "member/memberList";
	}
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-15
	 * 회원등록날짜에 맞는 회원목록 조회
	 */
	@GetMapping("/searchDateMemberList")  
	public String searchDateMemberList(Model model
									,@RequestParam(value="startDate", required = false) String startDate
									,@RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		
		List<Member> searchDateMemberList = memberService.searchDateMemberList(startDate, endDate);
		
		model.addAttribute("memberList", searchDateMemberList);
		
		return "member/memberList";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-16
	 * 회원 권한별 회원목록 조회
	 * */
	@GetMapping("/searchLevelMemberList")
	public String searchLevelMemberList(Model model
			,@RequestParam(value="memberLevel", required = false) String memberLevel) {
		
		log.info("권한별 회원 조회:{}", memberLevel);
		
		List<Member> searchLevelMemberList = memberService.searchLevelMemberList(memberLevel);
		
		model.addAttribute("memberList", searchLevelMemberList);
		
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
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-02
	 * 회원 상세 정보 내역 조회
	 * */
	@GetMapping("/detailMember")
	public String getDetailMemberInfo(Model model
									,@RequestParam(name="memberId",required = false) String memberId) {
		
		Member member = memberService.getMemberInfoById(memberId);
		
		log.info("회원상세정보:{}", member);
		
		model.addAttribute("title", "FoodRefurb : 회원 정보");
		model.addAttribute("titleName", "회원 상세정보");
		model.addAttribute("member", member);
		
		return "member/detailMember";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-03
	 * 상세회원정보 회원 정보 수정
	 * */
	@PostMapping("/detailMember")
	public String modifyMember(Member member) {
			
		log.info("회원수정정보:{}", member);
			
		memberService.modifyMember(member);
			
			return "redirect:/member/memberList";
	}
	
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-09
	 * */
	@GetMapping("/loginList")
	public String loginHistoryList(Model model) {
		
		List<LoginHistory> loginHistoryList = memberService.getLoginHistory();
		
		log.info("로그인내역:{}", loginHistoryList);
		
		model.addAttribute("title", "FoodRefurb : 회원 로그인");
		model.addAttribute("titleName", "회원 로그인 내역");
		model.addAttribute("loginHistoryList", loginHistoryList);
		
		return "member/loginList";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-09
	 * 회원 로그아웃 내역 조회
	 * */
	@GetMapping("/logoutList")
	public String logoutHistoryList(Model model) {
		
		List<LogoutHistory> logoutHistoryList = memberService.getLogoutHistory();
		
		log.info("로그아웃내역:{}", logoutHistoryList);
		
		model.addAttribute("title", "FoodRefurb : 회원 로그아웃");
		model.addAttribute("titleName", "회원 로그아웃 내역");
		model.addAttribute("logoutHistoryList", logoutHistoryList);
		
		return "member/logoutList";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-05
	 * 판매자 등급 혜택 및 기준 조회
	 * */
	@GetMapping("/sellerGrade")
	public String sellerGrade(Model model) {
		
		List<SellerGrade> sellerGradeList = memberService.sellerStandard();
		
		log.info("회원등급목록:{}", sellerGradeList);
		
		model.addAttribute("title", "FoodRefurb : 회원 등급");
		model.addAttribute("titleName", "회원 등급 혜택 및 기준");
		model.addAttribute("sellerGradeList", sellerGradeList);
		
		return "member/sellerGrade";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-05
	 * 판매자 등급 혜택 및 기준 수정
	 * */
	@GetMapping("/modifySellerGrade")
	public String modifySellerGrade(Model model
									,@RequestParam(name="sellerGradeNum", required = false) String sellerGradeNum) {
		
		SellerGrade sellerGrade = memberService.getSellerStandardByNum(sellerGradeNum);
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 및 혜택 수정");
		model.addAttribute("titleName", "등급 기준 및 혜택 수정");
		model.addAttribute("sellerGrade", sellerGrade);
		
		return "member/modifySellerGrade";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-05
	 * 판매자 등급 혜택 및 기준 수정
	 * */
	@PostMapping("/modifySellerGrade")
	public String modifySellerGrade(SellerGrade sellerGrade) {
		
		log.info("판매자 기준 정보:{}", sellerGrade);
		
		memberService.modifySellerGrade(sellerGrade);
		
		return "redirect:/member/sellerGrade";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-08
	 * 등급 혜택 및 기준 삭제 폼
	 * */
	@GetMapping("/removeSellerGradeBenefit")
	public String removeSellerGradeBenefit(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 혜택 및 기준 삭제");
		model.addAttribute("titleName", "등급 혜택 및 기준 삭제");
		
		return "member/removeSellerGradeBenefit";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-07
	 * 판매자 사업장 목록 조회
	 * */
	@GetMapping("/sellerStoreInfo")
	public String sellerStoreInfo(Model model) {
		
		
		List<SellerStore> sellerStoreList = memberService.sellerStoreInfo();
		
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
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-08
	 * 판매자 사업장 목록 조회
	 * */
	@GetMapping("/detailSellerStoreInfo")
	public String detailSellerStoreInfo(Model model
										,@RequestParam(name = "sellerStoreNum" , required = false) String sellerStoreNum) {
		
		SellerStore sellerStore = memberService.getSellStoreInfo(sellerStoreNum);
		
		log.info("사업장 상세정보:{}", sellerStore);
		
		model.addAttribute("title", "FoodRefurb : 사업장 정보");
		model.addAttribute("titleName", "사업장 상세정보");
		model.addAttribute("sellerStore", sellerStore);
		
		return "member/detailSellerStoreInfo";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-08
	 * 판매자 사업장 상세내역 조회
	 * */
	@PostMapping("/detailSellerStoreInfo")
	public String modifySellerStore(SellerStore sellerStore) {
			
		log.info("회원수정정보:{}", sellerStore);
			
		memberService.modifySellerStore(sellerStore);
			
			return "redirect:/member/sellerStoreInfo";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-07
	 * 기간별 판매자 사업장 목록 조회
	 * */
	@GetMapping("/searchDateSellerList")
	public String searchDateSellerList(Model model
									,@RequestParam(value="startDate", required = false) String startDate
									,@RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("시작날짜 검색:{}", startDate);
		log.info("종료날짜 검색:{}", endDate);
		
		List<SellerStore> searchDateSellerList = memberService.searchDateSellerList(startDate, endDate);
		
		model.addAttribute("sellerStoreList", searchDateSellerList);
		
		return "member/sellerStoreInfo";
		
	}
	
}
