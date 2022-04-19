package com.kfarmstar.dto;

public class GoodsRefund {
	private String refundCode;
	private String paymentCompleteCode;
	private String memberId;
	private String goodsRefurbCode;
	private String refundReasonContent;
	private String refundReceiptDate;
	private String refundProcessState;
	private int refundCount;
	private int refundPrice;
	
	private AfterPayment afterPayment;
	private Member member;
	private Goods goods;
	
	public String getRefundCode() {
		return refundCode;
	}
	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
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
	public String getGoodsRefurbCode() {
		return goodsRefurbCode;
	}
	public void setGoodsRefurbCode(String goodsRefurbCode) {
		this.goodsRefurbCode = goodsRefurbCode;
	}
	public String getRefundReasonContent() {
		return refundReasonContent;
	}
	public void setRefundReasonContent(String refundReasonContent) {
		this.refundReasonContent = refundReasonContent;
	}
	public String getRefundReceiptDate() {
		return refundReceiptDate;
	}
	public void setRefundReceiptDate(String refundReceiptDate) {
		this.refundReceiptDate = refundReceiptDate;
	}
	public String getRefundProcessState() {
		return refundProcessState;
	}
	public void setRefundProcessState(String refundProcessState) {
		this.refundProcessState = refundProcessState;
	}
	public int getRefundCount() {
		return refundCount;
	}
	public void setRefundCount(int refundCount) {
		this.refundCount = refundCount;
	}
	public int getRefundPrice() {
		return refundPrice;
	}
	public void setRefundPrice(int refundPrice) {
		this.refundPrice = refundPrice;
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
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsRefund [refundCode=");
		builder.append(refundCode);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", refundReasonContent=");
		builder.append(refundReasonContent);
		builder.append(", refundReceiptDate=");
		builder.append(refundReceiptDate);
		builder.append(", refundProcessState=");
		builder.append(refundProcessState);
		builder.append(", refundCount=");
		builder.append(refundCount);
		builder.append(", refundPrice=");
		builder.append(refundPrice);
		builder.append(", afterPayment=");
		builder.append(afterPayment);
		builder.append(", member=");
		builder.append(member);
		builder.append(", goods=");
		builder.append(goods);
		builder.append("]");
		return builder.toString();
	}
	
	
}
