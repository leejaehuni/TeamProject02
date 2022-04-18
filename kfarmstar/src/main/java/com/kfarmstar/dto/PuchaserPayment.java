package com.kfarmstar.dto;
/*깃허브수정*/
public class PuchaserPayment {

	private String purchaserPaymentCode;
	private String goodsRefurbCode;
	private String memberId;
	private String beforeMidSumCode;
	private int beforeGoodsCount;
	private int midSumPrice;
	private String paymentOption;
	private String deliveryPostnumAddr;
	private String deliveryAddr;
	private String deliveryDetailAddr;
	private String recipientName;
	private String recipientPhone;
	
	private Goods goods;
	private Member member;
	public String getPurchaserPaymentCode() {
		return purchaserPaymentCode;
	}
	public void setPurchaserPaymentCode(String purchaserPaymentCode) {
		this.purchaserPaymentCode = purchaserPaymentCode;
	}
	public String getGoodsRefurbCode() {
		return goodsRefurbCode;
	}
	public void setGoodsRefurbCode(String goodsRefurbCode) {
		this.goodsRefurbCode = goodsRefurbCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBeforeMidSumCode() {
		return beforeMidSumCode;
	}
	public void setBeforeMidSumCode(String beforeMidSumCode) {
		this.beforeMidSumCode = beforeMidSumCode;
	}
	public int getBeforeGoodsCount() {
		return beforeGoodsCount;
	}
	public void setBeforeGoodsCount(int beforeGoodsCount) {
		this.beforeGoodsCount = beforeGoodsCount;
	}
	public int getMidSumPrice() {
		return midSumPrice;
	}
	public void setMidSumPrice(int midSumPrice) {
		this.midSumPrice = midSumPrice;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getDeliveryPostnumAddr() {
		return deliveryPostnumAddr;
	}
	public void setDeliveryPostnumAddr(String deliveryPostnumAddr) {
		this.deliveryPostnumAddr = deliveryPostnumAddr;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getDeliveryDetailAddr() {
		return deliveryDetailAddr;
	}
	public void setDeliveryDetailAddr(String deliveryDetailAddr) {
		this.deliveryDetailAddr = deliveryDetailAddr;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
		builder.append("PuchaserPayment [purchaserPaymentCode=");
		builder.append(purchaserPaymentCode);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", beforeMidSumCode=");
		builder.append(beforeMidSumCode);
		builder.append(", beforeGoodsCount=");
		builder.append(beforeGoodsCount);
		builder.append(", midSumPrice=");
		builder.append(midSumPrice);
		builder.append(", paymentOption=");
		builder.append(paymentOption);
		builder.append(", deliveryPostnumAddr=");
		builder.append(deliveryPostnumAddr);
		builder.append(", deliveryAddr=");
		builder.append(deliveryAddr);
		builder.append(", deliveryDetailAddr=");
		builder.append(deliveryDetailAddr);
		builder.append(", recipientName=");
		builder.append(recipientName);
		builder.append(", recipientPhone=");
		builder.append(recipientPhone);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
