package com.kfarmstar.dto;

public class LoginHistory {
	
	private String loginNum;
	private String memberId;
	private String loginTime;
	
	private Member member;

	public String getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
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
		builder.append("LoginHistory [loginNum=");
		builder.append(loginNum);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", loginTime=");
		builder.append(loginTime);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	
	
}
