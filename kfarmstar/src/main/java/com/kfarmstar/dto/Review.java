package com.kfarmstar.dto;

public class Review {
	private String reviewNum;
	private String memberId;
	private String paymentCompleteCode;
	private String goodsRefurbCode;
	private String reviewScoreCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewImg;
	private String reviewEntryDate;
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
	public String getReviewScoreCode() {
		return reviewScoreCode;
	}
	public void setReviewScoreCode(String reviewScoreCode) {
		this.reviewScoreCode = reviewScoreCode;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
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
	public String getReviewEntryDate() {
		return reviewEntryDate;
	}
	public void setReviewEntryDate(String reviewEntryDate) {
		this.reviewEntryDate = reviewEntryDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewNum=");
		builder.append(reviewNum);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", reviewScoreCode=");
		builder.append(reviewScoreCode);
		builder.append(", reviewTitle=");
		builder.append(reviewTitle);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", reviewImg=");
		builder.append(reviewImg);
		builder.append(", reviewEntryDate=");
		builder.append(reviewEntryDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
