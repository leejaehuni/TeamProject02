package com.kfarmstar.dto;

public class DonationApply {
	/**
	 * 기부 사용처 신청
	 */
	private String donationApplyNum;
	private String memberId;
	private String donationApplyDate;
	private String donationApplyInfo;
	private String donationApplyCompletion;
	private String donationLicenseState;
	private String donationLicenseNum;
	
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getDonationApplyNum() {
		return donationApplyNum;
	}
	public void setDonationApplyNum(String donationApplyNum) {
		this.donationApplyNum = donationApplyNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getDonationApplyDate() {
		return donationApplyDate;
	}
	public void setDonationApplyDate(String donationApplyDate) {
		this.donationApplyDate = donationApplyDate;
	}
	public String getDonationApplyInfo() {
		return donationApplyInfo;
	}
	public void setDonationApplyInfo(String donationApplyInfo) {
		this.donationApplyInfo = donationApplyInfo;
	}
	public String getDonationApplyCompletion() {
		return donationApplyCompletion;
	}
	public void setDonationApplyCompletion(String donationApplyCompletion) {
		this.donationApplyCompletion = donationApplyCompletion;
	}
	public String getDonationLicenseState() {
		return donationLicenseState;
	}
	public void setDonationLicenseState(String donationLicenseState) {
		this.donationLicenseState = donationLicenseState;
	}
	public String getDonationLicenseNum() {
		return donationLicenseNum;
	}
	public void setDonationLicenseNum(String donationLicenseNum) {
		this.donationLicenseNum = donationLicenseNum;
	}
	@Override
	public String toString() {
		return "DonationApply [donationApplyNum=" + donationApplyNum + ", memberId=" + memberId + ", donationApplyDate="
				+ donationApplyDate + ", donationApplyInfo=" + donationApplyInfo + ", donationApplyCompletion="
				+ donationApplyCompletion + ", donationLicenseState=" + donationLicenseState + ", donationLicenseNum="
				+ donationLicenseNum + ", member=" + member + "]";
	}
	
}
