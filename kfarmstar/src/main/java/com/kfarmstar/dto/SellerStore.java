package com.kfarmstar.dto;
/*깃허브수정*/
public class SellerStore {
	private String sellerStoreNum;
	private String memberId;
	private String sellerStoreName;
	private String sellerLicenseNum;
	private String sellerStorePhone;
	private String sellerEntryDate;
	private String sellerStorePostNum;
	private String sellerStoreAddr;
	private String sellerStoreDetailAddr;
	private String sellerTaxType;
	
	private Member member;

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

	public String getSellerStoreName() {
		return sellerStoreName;
	}

	public void setSellerStoreName(String sellerStoreName) {
		this.sellerStoreName = sellerStoreName;
	}

	public String getSellerLicenseNum() {
		return sellerLicenseNum;
	}

	public void setSellerLicenseNum(String sellerLicenseNum) {
		this.sellerLicenseNum = sellerLicenseNum;
	}

	public String getSellerStorePhone() {
		return sellerStorePhone;
	}

	public void setSellerStorePhone(String sellerStorePhone) {
		this.sellerStorePhone = sellerStorePhone;
	}

	public String getSellerEntryDate() {
		return sellerEntryDate;
	}

	public void setSellerEntryDate(String sellerEntryDate) {
		this.sellerEntryDate = sellerEntryDate;
	}

	public String getSellerStorePostNum() {
		return sellerStorePostNum;
	}

	public void setSellerStorePostNum(String sellerStorePostNum) {
		this.sellerStorePostNum = sellerStorePostNum;
	}

	public String getSellerStoreAddr() {
		return sellerStoreAddr;
	}

	public void setSellerStoreAddr(String sellerStoreAddr) {
		this.sellerStoreAddr = sellerStoreAddr;
	}

	public String getSellerStoreDetailAddr() {
		return sellerStoreDetailAddr;
	}

	public void setSellerStoreDetailAddr(String sellerStoreDetailAddr) {
		this.sellerStoreDetailAddr = sellerStoreDetailAddr;
	}

	public String getSellerTaxType() {
		return sellerTaxType;
	}

	public void setSellerTaxType(String sellerTaxType) {
		this.sellerTaxType = sellerTaxType;
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
		builder.append("SellerStore [sellerStoreNum=");
		builder.append(sellerStoreNum);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", sellerStoreName=");
		builder.append(sellerStoreName);
		builder.append(", sellerLicenseNum=");
		builder.append(sellerLicenseNum);
		builder.append(", sellerStorePhone=");
		builder.append(sellerStorePhone);
		builder.append(", sellerEntryDate=");
		builder.append(sellerEntryDate);
		builder.append(", sellerStorePostNum=");
		builder.append(sellerStorePostNum);
		builder.append(", sellerStoreAddr=");
		builder.append(sellerStoreAddr);
		builder.append(", sellerStoreDetailAddr=");
		builder.append(sellerStoreDetailAddr);
		builder.append(", sellerTaxType=");
		builder.append(sellerTaxType);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

}
