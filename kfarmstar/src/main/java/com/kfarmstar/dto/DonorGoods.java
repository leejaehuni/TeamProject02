package com.kfarmstar.dto;

public class DonorGoods {
	
	private String donationBoardCode;
	private String sellerStoreNum;
	private String memberId;
	private String goodsDonationImg;
	private String donationContent;
	private String goodsDonationCount;
	private String goodsDonationName;
	private String goodsDonationDeliveryWay;
	private String donationRequestEntryDate;
	public String getDonationBoardCode() {
		return donationBoardCode;
	}
	public void setDonationBoardCode(String donationBoardCode) {
		this.donationBoardCode = donationBoardCode;
	}
	public String getSellerStoreNum() {
		return sellerStoreNum;
	}
	public void setSellerStoreNum(String sellerStoreNum) {
		this.sellerStoreNum = sellerStoreNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGoodsDonationImg() {
		return goodsDonationImg;
	}
	public void setGoodsDonationImg(String goodsDonationImg) {
		this.goodsDonationImg = goodsDonationImg;
	}
	public String getDonationContent() {
		return donationContent;
	}
	public void setDonationContent(String donationContent) {
		this.donationContent = donationContent;
	}
	public String getGoodsDonationCount() {
		return goodsDonationCount;
	}
	public void setGoodsDonationCount(String goodsDonationCount) {
		this.goodsDonationCount = goodsDonationCount;
	}
	public String getGoodsDonationName() {
		return goodsDonationName;
	}
	public void setGoodsDonationName(String goodsDonationName) {
		this.goodsDonationName = goodsDonationName;
	}
	public String getGoodsDonationDeliveryWay() {
		return goodsDonationDeliveryWay;
	}
	public void setGoodsDonationDeliveryWay(String goodsDonationDeliveryWay) {
		this.goodsDonationDeliveryWay = goodsDonationDeliveryWay;
	}
	public String getDonationRequestEntryDate() {
		return donationRequestEntryDate;
	}
	public void setDonationRequestEntryDate(String donationRequestEntryDate) {
		this.donationRequestEntryDate = donationRequestEntryDate;
	}
	@Override
	public String toString() {
		return "DonorGoods [donationBoardCode=" + donationBoardCode + ", sellerStoreNum=" + sellerStoreNum
				+ ", memberId=" + memberId + ", goodsDonationImg=" + goodsDonationImg + ", donationContent="
				+ donationContent + ", goodsDonationCount=" + goodsDonationCount + ", goodsDonationName="
				+ goodsDonationName + ", goodsDonationDeliveryWay=" + goodsDonationDeliveryWay
				+ ", donationRequestEntryDate=" + donationRequestEntryDate + "]";
	}
	
	
	
}
