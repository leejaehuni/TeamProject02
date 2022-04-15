package com.kfarmstar.dto;
/*깃허브수정*/
public class Basket {
	
	private String basketCode;
	private String goodsRefurbCode;
	private String memberId;
	private int basketCount;
	private int basketPrice;
	private String beforeMidSumCode;
	
	private Goods goods;
	private Member member;
	public String getBasketCode() {
		return basketCode;
	}
	public void setBasketCode(String basketCode) {
		this.basketCode = basketCode;
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
	public int getBasketCount() {
		return basketCount;
	}
	public void setBasketCount(int basketCount) {
		this.basketCount = basketCount;
	}
	public int getBasketPrice() {
		return basketPrice;
	}
	public void setBasketPrice(int basketPrice) {
		this.basketPrice = basketPrice;
	}
	public String getBeforeMidSumCode() {
		return beforeMidSumCode;
	}
	public void setBeforeMidSumCode(String beforeMidSumCode) {
		this.beforeMidSumCode = beforeMidSumCode;
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
		builder.append("Basket [basketCode=");
		builder.append(basketCode);
		builder.append(", goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", basketCount=");
		builder.append(basketCount);
		builder.append(", basketPrice=");
		builder.append(basketPrice);
		builder.append(", beforeMidSumCode=");
		builder.append(beforeMidSumCode);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
