package com.kfarmstar.dto;

public class Statistics {
	
	private String goodsStatisticsCode;
	private String goodsSalesAmount;
	private String goodsSalesPrice;
	private String searchYear;
	private String searchMonth;
	private String searchWeek;
	private String searchDay;
	private String goodsLargeCode;
	private String goodsSmallCode;
	private String paymentCompleteCode;
	private String memberId;
	
	private GoodsLarge goodsLarge;
	private GoodsSmall goodsSmall;
	private AfterPayment afterPayment;
	private Member member;
	public String getGoodsStatisticsCode() {
		return goodsStatisticsCode;
	}
	public void setGoodsStatisticsCode(String goodsStatisticsCode) {
		this.goodsStatisticsCode = goodsStatisticsCode;
	}
	public String getGoodsSalesAmount() {
		return goodsSalesAmount;
	}
	public void setGoodsSalesAmount(String goodsSalesAmount) {
		this.goodsSalesAmount = goodsSalesAmount;
	}
	public String getGoodsSalesPrice() {
		return goodsSalesPrice;
	}
	public void setGoodsSalesPrice(String goodsSalesPrice) {
		this.goodsSalesPrice = goodsSalesPrice;
	}
	public String getSearchYear() {
		return searchYear;
	}
	public void setSearchYear(String searchYear) {
		this.searchYear = searchYear;
	}
	public String getSearchMonth() {
		return searchMonth;
	}
	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}
	public String getSearchWeek() {
		return searchWeek;
	}
	public void setSearchWeek(String searchWeek) {
		this.searchWeek = searchWeek;
	}
	public String getSearchDay() {
		return searchDay;
	}
	public void setSearchDay(String searchDay) {
		this.searchDay = searchDay;
	}
	public String getGoodsLargeCode() {
		return goodsLargeCode;
	}
	public void setGoodsLargeCode(String goodsLargeCode) {
		this.goodsLargeCode = goodsLargeCode;
	}
	public String getGoodsSmallCode() {
		return goodsSmallCode;
	}
	public void setGoodsSmallCode(String goodsSmallCode) {
		this.goodsSmallCode = goodsSmallCode;
	}
	public String getPaymentCompleteCode() {
		return paymentCompleteCode;
	}
	public void setPaymentCompleteCode(String paymentCompleteCode) {
		this.paymentCompleteCode = paymentCompleteCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public GoodsLarge getGoodsLarge() {
		return goodsLarge;
	}
	public void setGoodsLarge(GoodsLarge goodsLarge) {
		this.goodsLarge = goodsLarge;
	}
	public GoodsSmall getGoodsSmall() {
		return goodsSmall;
	}
	public void setGoodsSmall(GoodsSmall goodsSmall) {
		this.goodsSmall = goodsSmall;
	}
	public AfterPayment getAfterPayment() {
		return afterPayment;
	}
	public void setAfterPayment(AfterPayment afterPayment) {
		this.afterPayment = afterPayment;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Statistics [goodsStatisticsCode=" + goodsStatisticsCode + ", goodsSalesAmount=" + goodsSalesAmount
				+ ", goodsSalesPrice=" + goodsSalesPrice + ", searchYear=" + searchYear + ", searchMonth=" + searchMonth
				+ ", searchWeek=" + searchWeek + ", searchDay=" + searchDay + ", goodsLargeCode=" + goodsLargeCode
				+ ", goodsSmallCode=" + goodsSmallCode + ", paymentCompleteCode=" + paymentCompleteCode + ", memberId="
				+ memberId + ", goodsLarge=" + goodsLarge + ", goodsSmall=" + goodsSmall + ", afterPayment="
				+ afterPayment + ", member=" + member + "]";
	}
	

}
