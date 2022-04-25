package com.kfarmstar.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.NoticeBoardMapper;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.NoticeBoard;

@Service
@Transactional
public class NoticeBoardService {

	
	private static final Logger log = LoggerFactory.getLogger(NoticeBoardService.class);

	
	private NoticeBoardMapper noticeBoardMapper;
	private CommonMapper commonMapper;
	
	public NoticeBoardService(NoticeBoardMapper noticeBoardMapper, CommonMapper commonMapper) {
		this.noticeBoardMapper = noticeBoardMapper;
		this.commonMapper = commonMapper;
	}
	//공지 목록 조회
	public List<NoticeBoard> getNoticeBoardList() {
		System.out.println("getNoticeBoardList NoticeBoardService.java");

		List<NoticeBoard> noticeBoardList = noticeBoardMapper.getNoticeList();
		System.out.println(noticeBoardList+"<-- noticeBoardList getNoticeBoardList NoticeBoardService.java");
		
		return noticeBoardList;
		
	}
	
	//공지게시글 조회
	public NoticeBoard getDetailNotice(String noticeNum) {
		System.out.println("getDetailNotice NoticeBoardService.java");
		
		NoticeBoard detailNotice = noticeBoardMapper.getDetailNotice(noticeNum);
		System.out.println(detailNotice+"<-- noticeBoardList getNoticeBoardList NoticeBoardService.java");
		
		return detailNotice;
		
	}
	// 공지 입력
	public int addNotice(NoticeBoard noticeBoard, String sessionId) {
		 //pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("notice_num", "notice_board");
		  noticeBoard.setNoticeNum(newCode);
		  noticeBoard.setMemberId(sessionId);
		  
		  int result = noticeBoardMapper.addNotice(noticeBoard);
		  
		  return result;
	}
	
	//공지 수정
	public int modifyNotice(NoticeBoard noticeBoard) {
		
		return noticeBoardMapper.modifyNotice(noticeBoard);
	} 
   
	//공지 삭제
	public int removeNotice(String noticeBoard,String noticeNum) {
      
	   int result = noticeBoardMapper.removeNotice(noticeBoard,noticeNum);
      return result;
   }

}