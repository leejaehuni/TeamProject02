package com.kfarmstar.dto;

/**
 * DB정보
 * Table	: delivery_goods
 * FK Table	: after_payment_info
 * 			  before_purchaser_info
 * 			  goods_management
 * 			  company_employee
 * 			  delivery_company
 * 			  member
 */
public class DeliveryGoods {
	//기본키
	private String deliveryNum;
	
	//기본 컬럼
	private String status;
	private String registrationDate;
	private String expectedDate;
	
	//외래키
	private AfterPayment afterPayment;
	private PuchaserPayment puchaserPayment;
	private GoodsRefund goodsRefund;
	private CompanyEmployee companyEmployee;
	private DeliveryCompany deliveryCompany;
	private Member member;
	
	public String getDeliveryNum() 									{ return deliveryNum; }
	public String getStatus() 										{ return status; }
	public String getRegistrationDate() 							{ return registrationDate; }
	public String getExpectedDate() 								{ return expectedDate; }
	public AfterPayment getAfterPayment() 							{ return afterPayment; }
	public PuchaserPayment getPuchaserPayment() 					{ return puchaserPayment; }
	public GoodsRefund getGoodsRefund() 							{ return goodsRefund; }
	public CompanyEmployee getCompanyEmployee() 					{ return companyEmployee; }
	public DeliveryCompany getDeliveryCompany() 					{ return deliveryCompany; }
	public Member getMember() 										{ return member; }
	
	public void setDeliveryNum(String deliveryNum) 					{ this.deliveryNum = deliveryNum; }
	public void setStatus(String status) 							{ this.status = status; }
	public void setRegistrationDate(String registrationDate) 		{ this.registrationDate = registrationDate; }
	public void setExpectedDate(String expectedDate) 				{ this.expectedDate = expectedDate; }
	public void setAfterPayment(AfterPayment afterPayment) 			{ this.afterPayment = afterPayment; }
	public void setPuchaserPayment(PuchaserPayment puchaserPayment) { this.puchaserPayment = puchaserPayment; }
	public void setGoodsRefund(GoodsRefund goodsRefund) 			{ this.goodsRefund = goodsRefund; }
	public void setCompanyEmployee(CompanyEmployee companyEmployee)	{ this.companyEmployee = companyEmployee; }
	public void setDeliveryCompany(DeliveryCompany deliveryCompany)	{ this.deliveryCompany = deliveryCompany; }
	public void setMember(Member member) 							{ this.member = member; }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryGoods [deliveryNum=");
		builder.append(deliveryNum);
		builder.append(", status=");
		builder.append(status);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append(", expectedDate=");
		builder.append(expectedDate);
		builder.append(", afterPayment=");
		builder.append(afterPayment);
		builder.append(", puchaserPayment=");
		builder.append(puchaserPayment);
		builder.append(", goodsRefund=");
		builder.append(goodsRefund);
		builder.append(", companyEmployee=");
		builder.append(companyEmployee);
		builder.append(", deliveryCompany=");
		builder.append(deliveryCompany);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
