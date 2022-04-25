package com.kfarmstar.dto;

import java.util.Date;

public class Review {
	private String reviewNum;
	private String memberId;
	private String paymentCompleteCode;
	private String goodsRefurbCode;
	private double reviewScoreCode;
	private String reviewContent;
	private String reviewImg;
	private Date reviewEntryDate;
	
	private Member member;
	private AfterPayment afterPayment;
	private GoodsRefund goodsRefund;
	private ReviewScore reviewScore;
	
	public ReviewScore getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(ReviewScore reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPaymentCompleteCode() {
		return paymentCompleteCode;
	}
	public void setPaymentCompleteCode(String paymentCompleteCode) {
		this.paymentCompleteCode = paymentCompleteCode;
	}
	public String getGoodsRefurbCode() {
		return goodsRefurbCode;
	}
	public void setGoodsRefurbCode(String goodsRefurbCode) {
		this.goodsRefurbCode = goodsRefurbCode;
	}
	public double getReviewScoreCode() {
		return reviewScoreCode;
	}
	public void setReviewScoreCode(double reviewScoreCode) {
		this.reviewScoreCode = reviewScoreCode;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public Date getReviewEntryDate() {
		return reviewEntryDate;
	}
	public void setReviewEntryDate(Date reviewEntryDate) {
		this.reviewEntryDate = reviewEntryDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public AfterPayment getAfterPayment() {
		return afterPayment;
	}
	public void setAfterPayment(AfterPayment afterPayment) {
		this.afterPayment = afterPayment;
	}
	public GoodsRefund getGoodsRefund() {
		return goodsRefund;
	}
	public void setGoodsRefund(GoodsRefund goodsRefund) {
		this.goodsRefund = goodsRefund;
	}
	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", memberId=" + memberId + ", paymentCompleteCode="
				+ paymentCompleteCode + ", goodsRefurbCode=" + goodsRefurbCode + ", reviewScoreCode=" + reviewScoreCode
				+ ", reviewContent=" + reviewContent + ", reviewImg=" + reviewImg + ", reviewEntryDate="
				+ reviewEntryDate + ", member=" + member + ", afterPayment=" + afterPayment + ", goodsRefund="
				+ goodsRefund + ", reviewScore=" + reviewScore + "]";
	}
	
	
	
	
}
