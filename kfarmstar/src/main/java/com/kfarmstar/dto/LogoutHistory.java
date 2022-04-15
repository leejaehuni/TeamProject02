package com.kfarmstar.dto;
/*깃허브수정*/
public class LogoutHistory {
	
	private String logoutNum;
	private String memberId;
	private String logoutTime;
	
	private Member member;

	public String getLogoutNum() {
		return logoutNum;
	}

	public void setLogoutNum(String logoutNum) {
		this.logoutNum = logoutNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogoutHistory [logoutNum=");
		builder.append(logoutNum);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", logoutTime=");
		builder.append(logoutTime);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	
}
