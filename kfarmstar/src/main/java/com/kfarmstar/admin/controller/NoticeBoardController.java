package com.kfarmstar.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kfarmstar.admin.mapper.NoticeBoardMapper;
import com.kfarmstar.admin.service.NoticeBoardService;
import com.kfarmstar.dto.NoticeBoard;

@Controller
@RequestMapping("/noticeboard")
public class NoticeBoardController {


	private static final Logger log = LoggerFactory.getLogger(NoticeBoardController.class);
	
	private NoticeBoardService noticeBoardService;
	private NoticeBoardMapper noticeBoardMapper;
	
	public NoticeBoardController(NoticeBoardService noticeBoardService, NoticeBoardMapper noticeBoardMapper) {
		this.noticeBoardService = noticeBoardService;
		this.noticeBoardMapper = noticeBoardMapper;
	}
	
	
	
	// 게시글 자세히보기
		@RequestMapping(value="/getNoticeList")
		public ModelAndView detail(@RequestParam("reNum") String reNum) throws Exception {
			
			// 기존의 게시글 자세히 보기에서 추가된 부분
			noticeBoardService.updatenoticecnt(reNum);
			
			return new ModelAndView("detail","detail1",noticeBoardService.detail(reNum));
		}
	
	@GetMapping("/getNoticeList")
	public String getNoticeList(Model model) {

		System.out.println("getNoticeList NoticeBoardController.java");
		List<NoticeBoard> noticeBoardList = noticeBoardService.getNoticeBoardList();
		
		
		model.addAttribute("title", "FoodRefurb : 공지게시판 목록 조회");
		model.addAttribute("titleName", "공지게시판 목록 조회");
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		return "noticeboard/getNoticeList";
	}
	
	@GetMapping("/detailNotice")
	public String detailNotice(Model model
							,@RequestParam(name="noticeNum", required = false) String noticeNum) {
		log.info("공지게시글조회 : {}", noticeNum);
		NoticeBoard detailNotice = noticeBoardService.getDetailNotice(noticeNum);
		model.addAttribute("title", "FoodRefurb : 공지게시글 조회");
		model.addAttribute("titleName", "공지게시글 조회");
		model.addAttribute("detailNotice", detailNotice);
		
		return "noticeboard/detailNotice";
	}
	
	//공지 등록 화면 연결
	@GetMapping("/addNotice")
	public String addNotice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 공지 등록");
		model.addAttribute("titleName", "공지 등록");
		
		return "noticeboard/addNotice";
	}
	
	//공지 입력
	@PostMapping("/addNotice")
	public String addNotice(NoticeBoard noticeBoard, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		noticeBoardService.addNotice(noticeBoard, sessionId);
		
		return "redirect:/noticeboard/getNoticeList";
	}
	
	@GetMapping("/modifyNotice")
	public String modifyNotice(Model model, 
								@RequestParam(name="noticeNum", required = false) String noticeNum) {
		
		NoticeBoard detailNotice = noticeBoardService.getDetailNotice(noticeNum);
		
		model.addAttribute("title", "FoodRefurb : 공지게시판 수정");
		model.addAttribute("titleName", "공지게시판 수정" );
		model.addAttribute("detailNotice", detailNotice);
		
		return "noticeboard/modifyNotice";
	}
	
	
	@PostMapping("/modifyNotice")
	public String modifyNotice(NoticeBoard noticeBoard) {
		
		noticeBoardService.modifyNotice(noticeBoard);
		
		return "redirect:/noticeboard/getNoticeList";
		
	}
	
	@GetMapping("/removeNotice")
	public String removeNotice(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 공지게시판 삭제");
		model.addAttribute("titleName", "공지게시판 삭제");
		
		return "noticeboard/removeNotice";
	}
	
	
}