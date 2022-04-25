package com.kfarmstar.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kfarmstar.dto.Grade;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.user.mapper.UserMemberMapper;
import com.kfarmstar.user.service.UserMemberService;
/*깃허브수정*/
@Controller
@RequestMapping("/userMember")
public class UserMemberController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserMemberController.class);

	private UserMemberService userMemberService;
	private UserMemberMapper userMemberMapper;
	
	public UserMemberController(UserMemberService userMemberService, UserMemberMapper userMemberMapper) {
		this.userMemberService = userMemberService;
		this.userMemberMapper = userMemberMapper;
	}
	
	@PostMapping("/modifySellerMyPage")
	public String modifySellerMyPage(SellerStore sellerStore) {
		
		log.info("마이페이지 판매자 사업장 수정 정보:{}", sellerStore);
		
		userMemberService.modifySellerStore(sellerStore);
		
		return "redirect:/userMember/myPage";
	}
	
	@PostMapping("/modifyMemberMyPage")
	public String modifyMemberMyPage(Member member) {
		
		log.info("마이페이지 회원 수정 정보:{}", member);
		
		userMemberService.modifyMember(member);
		
		return "redirect:/userMember/myPage";
	}
	
	@GetMapping("/myPage")
	public String myPage(Model model
						,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		Member member = userMemberService.getMemberInfoById(sessionId);
		SellerStore sellerStore = userMemberService.getSellStoreInfo(sessionId);
		
		model.addAttribute("title", "Food Refurb : 마이페이지");
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("member", member);
		model.addAttribute("sellerStore", sellerStore);
		
		return "userMember/myPage";
	}
	
	@GetMapping("/beforeAddMember")
	public String beforeAddMember(Model model) {
			
		model.addAttribute("title", "Food Refurb : 이용약관");
		
		return "userMember/beforeAddMember";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-20
	 * 회원가입 시 아이디 중복 여부 확인
	 * */
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) {
		
		boolean idCheck = false;
		log.info("아이디중복체크 클릭시 요청받은 memberId의 값: {}", memberId);
		
		boolean result = userMemberMapper.isIdCheck(memberId);
		if(result) idCheck = true;
		
		log.info("아이디중복체크 여부 : {}", result);
		return idCheck;
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-20
	 * 구매자 권한 회원가입 폼
	 * */
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "Food Refurb : 구매자 회원가입");
		
		return "userMember/addMember";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-20
	 * 구매자 권한 회원가입 등록
	 * */
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		userMemberService.addMember(member);
		
		log.info("회원가입:{}", member);
		
		return "redirect:/userMain";
		
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-19
	 * 판매자 회원가입 화면
	 * */
	@GetMapping("/addSellerMember")
	public String addSellerMember(Model model) {
		
		model.addAttribute("title", "Food Refurb : 판매자 회원가입");
		
		return "userMember/addSellerMember";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-19
	 * 판매자 회원가입
	 * */
	@PostMapping("/addSellerMember")
	public String addSellerMember(SellerStore sellerStore
								,Member member
								,Grade grade
								,@RequestParam MultipartFile[] fileImage
								,HttpServletRequest request) {
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		userMemberService.addSellerStoreInfo(sellerStore, member, grade, fileImage, fileRealPath);
		
		log.info("판매자 회원 가입:{}");
		log.info("사업장 정보 기입:{}", sellerStore);
		
		return "redirect:/userMain";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-19
	 * 회원 로그인 화면
	 * */
	@GetMapping("/login")
	public String login(Model model
						,@RequestParam(value="result", required = false) String result) {
		
		model.addAttribute("title", "Food Refurb : 로그인");
		
		if(result != null) model.addAttribute("result", result);
		
		return "userMember/login";
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-19
	 * 회원 로그인 처리
	 * */
	@PostMapping("/login")
	public String login(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		
		log.info("{}",member);
		
		Member checkMember = userMemberMapper.getMemberInfoById(memberId);
		
		if(checkMember != null && checkMember.getMemberPw() != null && memberPw.equals(checkMember.getMemberPw())) {
			String sessionName = checkMember.getMemberName();
			String sessionLevel = checkMember.getMemberLevel();
			
			
			session.setAttribute("SID", memberId);
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);
			
			
			log.info("로그인성공");
			
			return "redirect:/userMain";
		}
		
		reAttr.addAttribute("result", "아이디 또는 비밀번호를 잘못 입력하셨습니다. 다시 확인해주세요.");
		
		return "redirect:/userMember/login";
		
	}
	
	/*
	 * 작성자 : 이재훈
	 * 작성일자 : 2022-04-19
	 * 회원 로그아웃 처리
	 * */
	@GetMapping("/logout")
	public String logout(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		session.invalidate();
		
		return "redirect:/userMember/login";
	}
	
}
