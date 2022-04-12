package com.kfarmstar.dto;

public class NoticeBoard {
	
	private String noticeNum;
	private String noticeTitle;
	private String noticeContent;
	private String noticeImg;
	private String noticeDate;
	private String noticeHit;

	private String memberId;
	private Member member;
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeImg() {
		return noticeImg;
	}
	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(String noticeHit) {
		this.noticeHit = noticeHit;
	}
	@Override
	public String toString() {
		return "NoticeBoard [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeImg=" + noticeImg + ", noticeDate=" + noticeDate + ", noticeHit=" + noticeHit
				+ ", memberId=" + memberId + ", member=" + member + "]";
	}
	
}
