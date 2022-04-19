package com.kfarmstar.dto;

public class AfterAdPay {

	private String adPayCompleteCode;
	private String adPaymentCode;
	private String adApplyCode;
	private String adPayTypeCode;
	private String adCate;
	private String adContractTerm;
	private String adStartDate;
	private String adEndDate;
	private String adContractPrice;
	
	private BeforeAdPay beforeAdPay;
	private AdApply adApply;
	private AdPayType adPayType;
	public String getAdPayCompleteCode() {
		return adPayCompleteCode;
	}
	public void setAdPayCompleteCode(String adPayCompleteCode) {
		this.adPayCompleteCode = adPayCompleteCode;
	}
	public String getAdPaymentCode() {
		return adPaymentCode;
	}
	public void setAdPaymentCode(String adPaymentCode) {
		this.adPaymentCode = adPaymentCode;
	}
	public String getAdApplyCode() {
		return adApplyCode;
	}
	public void setAdApplyCode(String adApplyCode) {
		this.adApplyCode = adApplyCode;
	}
	public String getAdPayTypeCode() {
		return adPayTypeCode;
	}
	public void setAdPayTypeCode(String adPayTypeCode) {
		this.adPayTypeCode = adPayTypeCode;
	}
	public String getAdCate() {
		return adCate;
	}
	public void setAdCate(String adCate) {
		this.adCate = adCate;
	}
	public String getAdContractTerm() {
		return adContractTerm;
	}
	public void setAdContractTerm(String adContractTerm) {
		this.adContractTerm = adContractTerm;
	}
	public String getAdStartDate() {
		return adStartDate;
	}
	public void setAdStartDate(String adStartDate) {
		this.adStartDate = adStartDate;
	}
	public String getAdEndDate() {
		return adEndDate;
	}
	public void setAdEndDate(String adEndDate) {
		this.adEndDate = adEndDate;
	}
	public String getAdContractPrice() {
		return adContractPrice;
	}
	public void setAdContractPrice(String adContractPrice) {
		this.adContractPrice = adContractPrice;
	}
	public BeforeAdPay getBeforeAdPay() {
		return beforeAdPay;
	}
	public void setBeforeAdPay(BeforeAdPay beforeAdPay) {
		this.beforeAdPay = beforeAdPay;
	}
	public AdApply getAdApply() {
		return adApply;
	}
	public void setAdApply(AdApply adApply) {
		this.adApply = adApply;
	}
	public AdPayType getAdPayType() {
		return adPayType;
	}
	public void setAdPayType(AdPayType adPayType) {
		this.adPayType = adPayType;
	}
	@Override
	public String toString() {
		return "AfterAdPay [adPayCompleteCode=" + adPayCompleteCode + ", adPaymentCode=" + adPaymentCode
				+ ", adApplyCode=" + adApplyCode + ", adPayTypeCode=" + adPayTypeCode + ", adCate=" + adCate
				+ ", adContractTerm=" + adContractTerm + ", adStartDate=" + adStartDate + ", adEndDate=" + adEndDate
				+ ", adContractPrice=" + adContractPrice + ", beforeAdPay=" + beforeAdPay + ", adApply=" + adApply
				+ ", adPayType=" + adPayType + "]";
	}
	
	
}
