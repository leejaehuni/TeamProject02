package com.kfarmstar.dto;

public class Grade {
	
	private String sellerIdGrade;
	private String memberId;
	private String sellerGradeNum;
	private String sellerGradeType;
	
	private Member member;
	private SellerGrade sellerGrade;
	
	public String getSellerIdGrade() {
		return sellerIdGrade;
	}
	public void setSellerIdGrade(String sellerIdGrade) {
		this.sellerIdGrade = sellerIdGrade;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSellerGradeNum() {
		return sellerGradeNum;
	}
	public void setSellerGradeNum(String sellerGradeNum) {
		this.sellerGradeNum = sellerGradeNum;
	}
	public String getSellerGradeType() {
		return sellerGradeType;
	}
	public void setSellerGradeType(String sellerGradeType) {
		this.sellerGradeType = sellerGradeType;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public SellerGrade getSellerGrade() {
		return sellerGrade;
	}
	public void setSellerGrade(SellerGrade sellerGrade) {
		this.sellerGrade = sellerGrade;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Grade [sellerIdGrade=");
		builder.append(sellerIdGrade);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", sellerGradeNum=");
		builder.append(sellerGradeNum);
		builder.append(", sellerGradeType=");
		builder.append(sellerGradeType);
		builder.append(", member=");
		builder.append(member);
		builder.append(", sellerGrade=");
		builder.append(sellerGrade);
		builder.append("]");
		return builder.toString();
	}
	
}
