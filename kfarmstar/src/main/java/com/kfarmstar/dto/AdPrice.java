package com.kfarmstar.dto;

public class AdPrice {
	
	private String adPriceCode;
	private String memberId;
	private String adCate;
	private String adPricePerDay;
	private String entryTime;
	private String updateManagerId;
	private String lastUpdateTime;
	
	private Member member;

	public String getAdPriceCode() {
		return adPriceCode;
	}

	public void setAdPriceCode(String adPriceCode) {
		this.adPriceCode = adPriceCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAdCate() {
		return adCate;
	}

	public void setAdCate(String adCate) {
		this.adCate = adCate;
	}

	public String getAdPricePerDay() {
		return adPricePerDay;
	}

	public void setAdPricePerDay(String adPricePerDay) {
		this.adPricePerDay = adPricePerDay;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getUpdateManagerId() {
		return updateManagerId;
	}

	public void setUpdateManagerId(String updateManagerId) {
		this.updateManagerId = updateManagerId;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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
		builder.append("AdPrice [adPriceCode=");
		builder.append(adPriceCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", adCate=");
		builder.append(adCate);
		builder.append(", adPricePerDay=");
		builder.append(adPricePerDay);
		builder.append(", entryTime=");
		builder.append(entryTime);
		builder.append(", updateManagerId=");
		builder.append(updateManagerId);
		builder.append(", lastUpdateTime=");
		builder.append(lastUpdateTime);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
