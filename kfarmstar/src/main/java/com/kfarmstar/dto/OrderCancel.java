package com.kfarmstar.dto;

public class OrderCancel {
	
	private String orderCancelCode;
	private String paymentCompleteCode;
	private String memberId;
	private String goodsRefurbCode;
	private String cancelReasonContent;
	private int cancelCount;
	private int cancelPrice;
	private String cancelRequestDate;
	
	private AfterPayment afterPayment;
	private Member member;
	private Goods goods;
	
	public String getOrderCancelCode() {
		return orderCancelCode;
	}
	public void setOrderCancelCode(String orderCancelCode) {
		this.orderCancelCode = orderCancelCode;
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
	public String getCancelReasonContent() {
		return cancelReasonContent;
	}
	public void setCancelReasonContent(String cancelReasonContent) {
		this.cancelReasonContent = cancelReasonContent;
	}
	public int getCancelCount() {
		return cancelCount;
	}
	public void setCancelCount(int cancelCount) {
		this.cancelCount = cancelCount;
	}
	public int getCancelPrice() {
		return cancelPrice;
	}
	public void setCancelPrice(int cancelPrice) {
		this.cancelPrice = cancelPrice;
	}
	public String getCancelRequestDate() {
		return cancelRequestDate;
	}
	public void setCancelRequestDate(String cancelRequestDate) {
		this.cancelRequestDate = cancelRequestDate;
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
		builder.append("OrderCancel [orderCancelCode=");
		builder.append(orderCancelCode);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", cancelReasonContent=");
		builder.append(cancelReasonContent);
		builder.append(", cancelCount=");
		builder.append(cancelCount);
		builder.append(", cancelPrice=");
		builder.append(cancelPrice);
		builder.append(", cancelRequestDate=");
		builder.append(cancelRequestDate);
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
