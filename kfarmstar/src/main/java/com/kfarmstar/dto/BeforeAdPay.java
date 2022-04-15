package com.kfarmstar.dto;

public class BeforeAdPay {

	private String adPaymentCode;
	private String adPriceCode;
	private String adApplyCode;
	private String memberId;
	private String sellerGradeNum;
	private String adPaymentPrice;
	private String adDiscount;
	private String adContractPrice;
	private String managerId;
	private String permitDate;
	
	private AdPrice adPrice;
	private AdApply adApply;
	private Member member;
	
	public String getAdPaymentCode() {
		return adPaymentCode;
	}
	public void setAdPaymentCode(String adPaymentCode) {
		this.adPaymentCode = adPaymentCode;
	}
	public String getAdPriceCode() {
		return adPriceCode;
	}
	public void setAdPriceCode(String adPriceCode) {
		this.adPriceCode = adPriceCode;
	}
	public String getAdApplyCode() {
		return adApplyCode;
	}
	public void setAdApplyCode(String adApplyCode) {
		this.adApplyCode = adApplyCode;
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
	public String getAdPaymentPrice() {
		return adPaymentPrice;
	}
	public void setAdPaymentPrice(String adPaymentPrice) {
		this.adPaymentPrice = adPaymentPrice;
	}
	public String getAdDiscount() {
		return adDiscount;
	}
	public void setAdDiscount(String adDiscount) {
		this.adDiscount = adDiscount;
	}
	public String getAdContractPrice() {
		return adContractPrice;
	}
	public void setAdContractPrice(String adContractPrice) {
		this.adContractPrice = adContractPrice;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPermitDate() {
		return permitDate;
	}
	public void setPermitDate(String permitDate) {
		this.permitDate = permitDate;
	}
	public AdPrice getAdPrice() {
		return adPrice;
	}
	public void setAdPrice(AdPrice adPrice) {
		this.adPrice = adPrice;
	}
	public AdApply getAdApply() {
		return adApply;
	}
	public void setAdApply(AdApply adApply) {
		this.adApply = adApply;
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
		builder.append("BeforeAdPay [adPaymentCode=");
		builder.append(adPaymentCode);
		builder.append(", adPriceCode=");
		builder.append(adPriceCode);
		builder.append(", adApplyCode=");
		builder.append(adApplyCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", sellerGradeNum=");
		builder.append(sellerGradeNum);
		builder.append(", adPaymentPrice=");
		builder.append(adPaymentPrice);
		builder.append(", adDiscount=");
		builder.append(adDiscount);
		builder.append(", adContractPrice=");
		builder.append(adContractPrice);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", permitDate=");
		builder.append(permitDate);
		builder.append(", adPrice=");
		builder.append(adPrice);
		builder.append(", adApply=");
		builder.append(adApply);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
