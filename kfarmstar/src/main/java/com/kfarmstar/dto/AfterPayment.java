package com.kfarmstar.dto;
/*깃허브수정*/
public class AfterPayment {

	private String paymentCompleteCode;
	private String purchaserPaymentCode;
	private String goodsRefurbCode;
	private String memberId;
	private String paymentTypeCode;
	private int beforeGoodsCount;
	private int midSumPrice;
	private String paymentOption;
	private int lastPaymentPrice;
	private String deliveryPostNum;
	private String deliveryAddr;
	private String deliveryDetailAddr;
	private String paymentDate;
	
	private PuchaserPayment puchaserPayment;
	private Goods goods;
	private Member member;
	private PaymentType paymentType;
	public String getPaymentCompleteCode() {
		return paymentCompleteCode;
	}
	public void setPaymentCompleteCode(String paymentCompleteCode) {
		this.paymentCompleteCode = paymentCompleteCode;
	}
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
	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}
	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
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
	public int getLastPaymentPrice() {
		return lastPaymentPrice;
	}
	public void setLastPaymentPrice(int lastPaymentPrice) {
		this.lastPaymentPrice = lastPaymentPrice;
	}
	public String getDeliveryPostNum() {
		return deliveryPostNum;
	}
	public void setDeliveryPostNum(String deliveryPostNum) {
		this.deliveryPostNum = deliveryPostNum;
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
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public PuchaserPayment getPuchaserPayment() {
		return puchaserPayment;
	}
	public void setPuchaserPayment(PuchaserPayment puchaserPayment) {
		this.puchaserPayment = puchaserPayment;
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
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AfterPayment [paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", purchaserPaymentCode=");
		builder.append(purchaserPaymentCode);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", paymentTypeCode=");
		builder.append(paymentTypeCode);
		builder.append(", beforeGoodsCount=");
		builder.append(beforeGoodsCount);
		builder.append(", midSumPrice=");
		builder.append(midSumPrice);
		builder.append(", paymentOption=");
		builder.append(paymentOption);
		builder.append(", lastPaymentPrice=");
		builder.append(lastPaymentPrice);
		builder.append(", deliveryPostNum=");
		builder.append(deliveryPostNum);
		builder.append(", deliveryAddr=");
		builder.append(deliveryAddr);
		builder.append(", deliveryDetailAddr=");
		builder.append(deliveryDetailAddr);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", puchaserPayment=");
		builder.append(puchaserPayment);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", member=");
		builder.append(member);
		builder.append(", paymentType=");
		builder.append(paymentType);
		builder.append("]");
		return builder.toString();
	}
	
}
