package com.kfarmstar.dto;
/*깃허브수정*/
public class GoodsExchange {
	private String goodsExchangeCode;
	private String paymentCompleteCode;
	private String memberId;
	private String goodsRefurbCode;
	private String exchangeReasonContent;
	private int exchangeCount;
	private String exchangeRequestDate;
	private String exchangeProcessState;
	
	private AfterPayment afterPayment;
	private Member member;
	private Goods goods;
	
	public String getGoodsExchangeCode() {
		return goodsExchangeCode;
	}
	public void setGoodsExchangeCode(String goodsExchangeCode) {
		this.goodsExchangeCode = goodsExchangeCode;
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
	public String getExchangeReasonContent() {
		return exchangeReasonContent;
	}
	public void setExchangeReasonContent(String exchangeReasonContent) {
		this.exchangeReasonContent = exchangeReasonContent;
	}
	public int getExchangeCount() {
		return exchangeCount;
	}
	public void setExchangeCount(int exchangeCount) {
		this.exchangeCount = exchangeCount;
	}
	public String getExchangeRequestDate() {
		return exchangeRequestDate;
	}
	public void setExchangeRequestDate(String exchangeRequestDate) {
		this.exchangeRequestDate = exchangeRequestDate;
	}
	public String getExchangeProcessState() {
		return exchangeProcessState;
	}
	public void setExchangeProcessState(String exchangeProcessState) {
		this.exchangeProcessState = exchangeProcessState;
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
		builder.append("GoodsExchange [goodsExchangeCode=");
		builder.append(goodsExchangeCode);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", exchangeReasonContent=");
		builder.append(exchangeReasonContent);
		builder.append(", exchangeCount=");
		builder.append(exchangeCount);
		builder.append(", exchangeRequestDate=");
		builder.append(exchangeRequestDate);
		builder.append(", exchangeProcessState=");
		builder.append(exchangeProcessState);
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
