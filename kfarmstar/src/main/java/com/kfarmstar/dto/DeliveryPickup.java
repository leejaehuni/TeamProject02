package com.kfarmstar.dto;

public class DeliveryPickup {
	//기본키
	private String pickupNum;
	
	//기본 컬럼
	private String pickupType;
	private String pickupRegistrationDate;
	
	//외래키
	private DeliveryCompany deliveryCompany;
	private CompanyEmployee companyEmployee;
	private DeliveryGoods deliveryGoods;
	private Member member;
	
	public String getPickupNum() 											{ return pickupNum; }
	public String getPickupType() 											{ return pickupType; }
	public String getPickupRegistrationDate() 								{ return pickupRegistrationDate; }
	public DeliveryCompany getDeliveryCompany()								{ return deliveryCompany; }
	public CompanyEmployee getCompanyEmployee() 							{ return companyEmployee; }
	public DeliveryGoods getDeliveryGoods() 								{ return deliveryGoods; }
	public Member getMember() 												{ return member; }
	
	public void setPickupNum(String pickupNum) 								{ this.pickupNum = pickupNum; }
	public void setPickupType(String pickupType) 							{ this.pickupType = pickupType; }
	public void setPickupRegistrationDate(String pickupRegistrationDate)	{ this.pickupRegistrationDate = pickupRegistrationDate; }
	public void setDeliveryCompany(DeliveryCompany deliveryCompany) 		{ this.deliveryCompany = deliveryCompany; }
	public void setCompanyEmployee(CompanyEmployee companyEmployee) 		{ this.companyEmployee = companyEmployee; }
	public void setDeliveryGoods(DeliveryGoods deliveryGoods) 				{ this.deliveryGoods = deliveryGoods; }
	public void setMember(Member member) 									{ this.member = member; }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryPickup [pickupNum=");
		builder.append(pickupNum);
		builder.append(", pickupType=");
		builder.append(pickupType);
		builder.append(", pickupRegistrationDate=");
		builder.append(pickupRegistrationDate);
		builder.append(", deliveryCompany=");
		builder.append(deliveryCompany);
		builder.append(", companyEmployee=");
		builder.append(companyEmployee);
		builder.append(", deliveryGoods=");
		builder.append(deliveryGoods);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
