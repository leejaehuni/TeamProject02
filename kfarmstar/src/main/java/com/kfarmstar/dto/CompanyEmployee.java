package com.kfarmstar.dto;

/**
 * DB정보
 * Table 	: company_employee
 * FK Table : member
 * 			  delivery_company
 */
public class CompanyEmployee {
	//기본키
	private String employeeNum;
	
	//기본 컬럼
	private String companyAffiliation;
	private String companyPosition;
	
	//외래키
	private Member member;
	private DeliveryCompany deliveryCompany;
	
	public String getEmployeeNum() 									{ return employeeNum; }
	public String getCompanyAffiliation() 							{ return companyAffiliation; }
	public String getCompanyPosition() 								{ return companyPosition; }
	public Member getMember() 										{ return member; }
	public DeliveryCompany getDeliveryCompany() 					{ return deliveryCompany; }
	
	public void setEmployeeNum(String employeeNum) 					{ this.employeeNum = employeeNum; }
	public void setCompanyAffiliation(String companyAffiliation) 	{ this.companyAffiliation = companyAffiliation; }
	public void setCompanyPosition(String companyPosition) 			{ this.companyPosition = companyPosition; }
	public void setMember(Member member) 							{ this.member = member; }
	public void setDeliveryCompany(DeliveryCompany deliveryCompany)	{ this.deliveryCompany = deliveryCompany; }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyEmployee [employeeNum=");
		builder.append(employeeNum);
		builder.append(", companyAffiliation=");
		builder.append(companyAffiliation);
		builder.append(", companyPosition=");
		builder.append(companyPosition);
		builder.append(", member=");
		builder.append(member);
		builder.append(", deliveryCompany=");
		builder.append(deliveryCompany);
		builder.append("]");
		return builder.toString();
	}
	
}
