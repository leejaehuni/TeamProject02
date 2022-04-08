package com.kfarmstar.dto;

public class PaymentType {
	private String paymentTypeCode;
	private String memberId;
	private String paymentCompleteCode;
	private String paymentCardType;
	private String paymentCardNum;
	private String paymentAccountInfo;
	private String paymentAccountNumber;
	private String paymentCarrier;
	private String paymentPhoneNum;
	
	private Member member;
	private AfterPayment afterPayment;
	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}
	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPaymentCompleteCode() {
		return paymentCompleteCode;
	}
	public void setPaymentCompleteCode(String paymentCompleteCode) {
		this.paymentCompleteCode = paymentCompleteCode;
	}
	public String getPaymentCardType() {
		return paymentCardType;
	}
	public void setPaymentCardType(String paymentCardType) {
		this.paymentCardType = paymentCardType;
	}
	public String getPaymentCardNum() {
		return paymentCardNum;
	}
	public void setPaymentCardNum(String paymentCardNum) {
		this.paymentCardNum = paymentCardNum;
	}
	public String getPaymentAccountInfo() {
		return paymentAccountInfo;
	}
	public void setPaymentAccountInfo(String paymentAccountInfo) {
		this.paymentAccountInfo = paymentAccountInfo;
	}
	public String getPaymentAccountNumber() {
		return paymentAccountNumber;
	}
	public void setPaymentAccountNumber(String paymentAccountNumber) {
		this.paymentAccountNumber = paymentAccountNumber;
	}
	public String getPaymentCarrier() {
		return paymentCarrier;
	}
	public void setPaymentCarrier(String paymentCarrier) {
		this.paymentCarrier = paymentCarrier;
	}
	public String getPaymentPhoneNum() {
		return paymentPhoneNum;
	}
	public void setPaymentPhoneNum(String paymentPhoneNum) {
		this.paymentPhoneNum = paymentPhoneNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public AfterPayment getAfterPayment() {
		return afterPayment;
	}
	public void setAfterPayment(AfterPayment afterPayment) {
		this.afterPayment = afterPayment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentType [paymentTypeCode=");
		builder.append(paymentTypeCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", paymentCardType=");
		builder.append(paymentCardType);
		builder.append(", paymentCardNum=");
		builder.append(paymentCardNum);
		builder.append(", paymentAccountInfo=");
		builder.append(paymentAccountInfo);
		builder.append(", paymentAccountNumber=");
		builder.append(paymentAccountNumber);
		builder.append(", paymentCarrier=");
		builder.append(paymentCarrier);
		builder.append(", paymentPhoneNum=");
		builder.append(paymentPhoneNum);
		builder.append(", member=");
		builder.append(member);
		builder.append(", afterPayment=");
		builder.append(afterPayment);
		builder.append("]");
		return builder.toString();
	}
	
	
}
