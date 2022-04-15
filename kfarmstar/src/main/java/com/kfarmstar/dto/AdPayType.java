package com.kfarmstar.dto;

public class AdPayType {
	
	private String adPayTypeCode;
	private String memberId;
	private String adPayOption;
	private String adPayCardType;
	private String adPayCardNum;
	private String adPayAccountType;
	private String adPayAccountNum;
	private String adPayPhoneCarrier;
	private String adPayPhoneNum;
	
	
	private Member member;

	public String getAdPayTypeCode() {
		return adPayTypeCode;
	}


	public void setAdPayTypeCode(String adPayTypeCode) {
		this.adPayTypeCode = adPayTypeCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getAdPayOption() {
		return adPayOption;
	}


	public void setAdPayOption(String adPayOption) {
		this.adPayOption = adPayOption;
	}


	public String getAdPayCardType() {
		return adPayCardType;
	}


	public void setAdPayCardType(String adPayCardType) {
		this.adPayCardType = adPayCardType;
	}


	public String getAdPayCardNum() {
		return adPayCardNum;
	}


	public void setAdPayCardNum(String adPayCardNum) {
		this.adPayCardNum = adPayCardNum;
	}


	public String getAdPayAccountType() {
		return adPayAccountType;
	}


	public void setAdPayAccountType(String adPayAccountType) {
		this.adPayAccountType = adPayAccountType;
	}


	public String getAdPayAccountNum() {
		return adPayAccountNum;
	}


	public void setAdPayAccountNum(String adPayAccountNum) {
		this.adPayAccountNum = adPayAccountNum;
	}


	public String getAdPayPhoneCarrier() {
		return adPayPhoneCarrier;
	}


	public void setAdPayPhoneCarrier(String adPayPhoneCarrier) {
		this.adPayPhoneCarrier = adPayPhoneCarrier;
	}


	public String getAdPayPhoneNum() {
		return adPayPhoneNum;
	}


	public void setAdPayPhoneNum(String adPayPhoneNum) {
		this.adPayPhoneNum = adPayPhoneNum;
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
		builder.append("AdPayType [adPayTypeCode=");
		builder.append(adPayTypeCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", adPayOption=");
		builder.append(adPayOption);
		builder.append(", adPayCardType=");
		builder.append(adPayCardType);
		builder.append(", adPayCardNum=");
		builder.append(adPayCardNum);
		builder.append(", adPayAccountType=");
		builder.append(adPayAccountType);
		builder.append(", adPayAccountNum=");
		builder.append(adPayAccountNum);
		builder.append(", adPayPhoneCarrier=");
		builder.append(adPayPhoneCarrier);
		builder.append(", adPayPhoneNum=");
		builder.append(adPayPhoneNum);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
	
}
