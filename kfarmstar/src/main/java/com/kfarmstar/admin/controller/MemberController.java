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
	
	@GetMapping("/conditionSellerStoreList")
	public String conditionSellerStoreList(Model model
											,@RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("조건별 판매자 사업장 검색:{}", searchValue);
		
		List<SellerStore> conditionSellerStoreList = memberService.conditionSellerStoreList(searchKey, searchValue);
		
		model.addAttribute("sellerStoreList", conditionSellerStoreList);
		
		return "member/sellerStoreInfo";
	}
	
	@GetMapping("/conditionMemberList")
	public String conditionMemberList(Model model
											,@RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("조건별 회원 검색:{}", searchValue);
		
		List<Member> conditionMemberList = memberService.conditionMemberList(searchKey, searchValue);
		
		model.addAttribute("memberList", conditionMemberList);
		
		return "member/memberList";
	}
	
	@PostMapping("/searchDate")
	@ResponseBody
	public List<Member> searchDate(@RequestParam(value="searchKey", required = false) String searchKey
							,@RequestParam(value = "searchValue", required = false) String searchValue) {
		
		log.info("기간검색");
		log.info("searchValue:{}", searchValue);
		
		List<Member> searchDate = memberService.searchDate(searchKey, searchValue);
		
		return searchDate;
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
	public String getDetailMemberInfo(Model model
									,@RequestParam(name="memberId",required = false) String memberId) {
		
		Member member = memberService.getMemberInfoById(memberId);
		
		log.info("회원상세정보:{}", member);
		
		model.addAttribute("title", "FoodRefurb : 회원 정보");
		model.addAttribute("titleName", "회원 상세정보");
		model.addAttribute("member", member);
		
		return "member/detailMember";
	}
	
	@PostMapping("/detailMember")
	public String modifyMember(Member member) {
			
		log.info("회원수정정보:{}", member);
			
		memberService.modifyMember(member);
			
			return "redirect:/member/memberList";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/loginList")
	public String loginHistoryList(Model model) {
		
		List<LoginHistory> loginHistoryList = memberService.getLoginHistory();
		
		log.info("로그인내역:{}", loginHistoryList);
		
		model.addAttribute("title", "FoodRefurb : 회원 로그인");
		model.addAttribute("titleName", "회원 로그인 내역");
		model.addAttribute("loginHistoryList", loginHistoryList);
		
		return "member/loginList";
	}
	
	@GetMapping("/logoutList")
	public String logoutHistoryList(Model model) {
		
		List<LogoutHistory> logoutHistoryList = memberService.getLogoutHistory();
		
		log.info("로그아웃내역:{}", logoutHistoryList);
		
		model.addAttribute("title", "FoodRefurb : 회원 로그아웃");
		model.addAttribute("titleName", "회원 로그아웃 내역");
		model.addAttribute("logoutHistoryList", logoutHistoryList);
		
		return "member/logoutList";
	}
	
	@GetMapping("/sellerGrade")
	public String sellerGrade(Model model) {
		
		List<SellerGrade> sellerGradeList = memberService.sellerStandard();
		
		log.info("회원등급목록:{}", sellerGradeList);
		
		model.addAttribute("title", "FoodRefurb : 회원 등급");
		model.addAttribute("titleName", "회원 등급 혜택 및 기준");
		model.addAttribute("sellerGradeList", sellerGradeList);
		
		return "member/sellerGrade";
	}
	
	@GetMapping("/modifySellerGrade")
	public String modifySellerGrade(Model model
									,@RequestParam(name="sellerGradeNum", required = false) String sellerGradeNum) {
		
		SellerGrade sellerGrade = memberService.getSellerStandardByNum(sellerGradeNum);
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 수정");
		model.addAttribute("titleName", "등급 기준 수정");
		model.addAttribute("sellerGrade", sellerGrade);
		
		return "member/modifySellerGrade";
	}
	
	@PostMapping("/modifySellerGrade")
	public String modifySellerGrade(SellerGrade sellerGrade) {
		
		log.info("판매자 기준 정보:{}", sellerGrade);
		
		memberService.modifySellerGrade(sellerGrade);
		
		return "redirect:/member/sellerGrade";
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
	
	@PostMapping("/detailSellerStoreInfo")
	public String modifySellerStore(SellerStore sellerStore) {
			
		log.info("회원수정정보:{}", sellerStore);
			
		memberService.modifySellerStore(sellerStore);
			
			return "redirect:/member/sellerStoreInfo";
	}
	
}
