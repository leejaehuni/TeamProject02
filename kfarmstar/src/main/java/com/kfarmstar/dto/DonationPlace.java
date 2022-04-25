package com.kfarmstar.dto;

public class DonationPlace {
	
	/**
	 * 기부사용처
	 */
	private String donationCenterNum;
	private String donationApplyNum;
	private String donationRecipientName;
	private String memberId;
	private String donationIntroduction;
	private String donationRecipientPhone;
	private String donationRecipientEmail;
	private String donationRecipientAddr;
	
	private DonationApply donationApply;
	
	public String getDonationIntroduction() {
		return donationIntroduction;
	}
	public void setDonationIntroduction(String donationIntroduction) {
		this.donationIntroduction = donationIntroduction;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public DonationApply getDonationApply() {
		return donationApply;
	}
	public void setDonationApply(DonationApply donationApply) {
		this.donationApply = donationApply;
	}
	public String getDonationCenterNum() {
		return donationCenterNum;
	}
	public void setDonationCenterNum(String donationCenterNum) {
		this.donationCenterNum = donationCenterNum;
	}
	public String getDonationApplyNum() {
		return donationApplyNum;
	}
	public void setDonationApplyNum(String donationApplyNum) {
		this.donationApplyNum = donationApplyNum;
	}
	public String getDonationRecipientName() {
		return donationRecipientName;
	}
	public void setDonationRecipientName(String donationRecipientName) {
		this.donationRecipientName = donationRecipientName;
	}
	public String getDonationRecipientPhone() {
		return donationRecipientPhone;
	}
	public void setDonationRecipientPhone(String donationRecipientPhone) {
		this.donationRecipientPhone = donationRecipientPhone;
	}
	public String getDonationRecipientEmail() {
		return donationRecipientEmail;
	}
	public void setDonationRecipientEmail(String donationRecipientEmail) {
		this.donationRecipientEmail = donationRecipientEmail;
	}
	public String getDonationRecipientAddr() {
		return donationRecipientAddr;
	}
	public void setDonationRecipientAddr(String donationRecipientAddr) {
		this.donationRecipientAddr = donationRecipientAddr;
	}
	@Override
	public String toString() {
		return "DonationPlace [donationCenterNum=" + donationCenterNum + ", donationApplyNum=" + donationApplyNum
				+ ", donationRecipientName=" + donationRecipientName + ", memberId=" + memberId
				+ ", donationIntroduction=" + donationIntroduction + ", donationRecipientPhone="
				+ donationRecipientPhone + ", donationRecipientEmail=" + donationRecipientEmail
				+ ", donationRecipientAddr=" + donationRecipientAddr + ", donationApply=" + donationApply + "]";
	}
	
}
