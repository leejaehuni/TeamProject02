package com.kfarmstar.dto;

public class ReviewScore {
	
	private String reviewScoreCode;
	private int starCount;
	private int reviewScore;
	public String getReviewScoreCode() {
		return reviewScoreCode;
	}
	public void setReviewScoreCode(String reviewScoreCode) {
		this.reviewScoreCode = reviewScoreCode;
	}
	public int getStarCount() {
		return starCount;
	}
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewScore [reviewScoreCode=");
		builder.append(reviewScoreCode);
		builder.append(", starCount=");
		builder.append(starCount);
		builder.append(", reviewScore=");
		builder.append(reviewScore);
		builder.append("]");
		return builder.toString();
	}
	
}
