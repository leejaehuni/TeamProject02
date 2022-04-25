package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.NoticeBoard;

@Mapper
public interface NoticeBoardMapper {

	//공지게시판 목록 조회
	public List<NoticeBoard> getNoticeList();
	
	//공지 게시글 조회
	public NoticeBoard getDetailNotice(String noticeNum);
	
	//공지 입력
	public int addNotice(NoticeBoard notice);
	
	//공지 수정
	public int modifyNotice(NoticeBoard notice);
	
	//공지 삭제
	public int removeNotice(String noticeBoard,String noticeNum);
}
