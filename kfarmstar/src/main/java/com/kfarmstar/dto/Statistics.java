package com.kfarmstar.dto;

public class Statistics {
	
	private String goodsStatisticsCode;
	private String goodsSalesAmount;
	private String goodsSalesPrice;
	private String searchYear;
	private String searchMonth;
	private String searchWeek;
	private String searchDay;
	private String goodsLargeCate;
	private String goodsSmallCate;
	private String paymentCompleteCode;
	private String memberId;
	private String lastPaymentPrice;
	private String paymentDate;
	private String beforeGoodsCount;
	private String goodsSmallName;
	
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
	public String getGoodsLargeCate() {
		return goodsLargeCate;
	}
	public void setGoodsLargeCate(String goodsLargeCate) {
		this.goodsLargeCate = goodsLargeCate;
	}
	public String getGoodsSmallCate() {
		return goodsSmallCate;
	}
	public void setGoodsSmallCate(String goodsSmallCate) {
		this.goodsSmallCate = goodsSmallCate;
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
	public String getLastPaymentPrice() {
		return lastPaymentPrice;
	}
	public void setLastPaymentPrice(String lastPaymentPrice) {
		this.lastPaymentPrice = lastPaymentPrice;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getBeforeGoodsCount() {
		return beforeGoodsCount;
	}
	public void setBeforeGoodsCount(String beforeGoodsCount) {
		this.beforeGoodsCount = beforeGoodsCount;
	}
	public String getGoodsSmallName() {
		return goodsSmallName;
	}
	public void setGoodsSmallName(String goodsSmallName) {
		this.goodsSmallName = goodsSmallName;
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
				+ ", searchWeek=" + searchWeek + ", searchDay=" + searchDay + ", goodsLargeCate=" + goodsLargeCate
				+ ", goodsSmallCate=" + goodsSmallCate + ", paymentCompleteCode=" + paymentCompleteCode + ", memberId="
				+ memberId + ", lastPaymentPrice=" + lastPaymentPrice + ", paymentDate=" + paymentDate
				+ ", beforeGoodsCount=" + beforeGoodsCount + ", goodsSmallName=" + goodsSmallName + ", goodsLarge="
				+ goodsLarge + ", goodsSmall=" + goodsSmall + ", afterPayment=" + afterPayment + ", member=" + member
				+ "]";
	}
	


}
