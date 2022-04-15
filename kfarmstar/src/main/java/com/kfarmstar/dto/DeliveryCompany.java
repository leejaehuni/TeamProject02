package com.kfarmstar.dto;

/**
 * DB정보
 * Table 	: delivery_company
 * FK Table : member
 */
public class DeliveryCompany {
	//기본키
	private String 	companyCode;
	
	//기본 컬럼
	private String 	companyNum;
	private String 	companySectors;
	private String 	companyScale;
	private String 	companyName;
	private String 	companyPhone;
	private String 	companyAddr;
	private String 	companyAddrDetail;
	private String 	companyEmail;
	private String 	companyFax;
	private int 	companyEmployeeNum;
	private String 	companyRegistrationDate;
	
	//외래키
	private Member 	member;

	public String getCompanyCode() 											{ return companyCode; }
	public String getCompanyNum() 											{ return companyNum; }
	public String getCompanySectors() 										{ return companySectors; }
	public String getCompanyScale() 										{ return companyScale; }
	public String getCompanyName() 											{ return companyName; }
	public String getCompanyPhone() 										{ return companyPhone; }
	public String getCompanyAddr() 											{ return companyAddr; }
	public String getCompanyAddrDetail() 									{ return companyAddrDetail; }
	public String getCompanyEmail() 										{ return companyEmail; }
	public String getCompanyFax() 											{ return companyFax; }
	public int getCompanyEmployeeNum() 										{ return companyEmployeeNum; }
	public String getCompanyRegistrationDate() 								{ return companyRegistrationDate; }
	public Member getMember() 												{ return member; }

	public void setCompanyCode(String companyCode) 							{ this.companyCode = companyCode; }
	public void setCompanyNum(String companyNum) 							{ this.companyNum = companyNum; }
	public void setCompanySectors(String companySectors) 					{ this.companySectors = companySectors; }
	public void setCompanyScale(String companyScale) 						{ this.companyScale = companyScale; }
	public void setCompanyName(String companyName) 							{ this.companyName = companyName; }
	public void setCompanyPhone(String companyPhone) 						{ this.companyPhone = companyPhone; }
	public void setCompanyAddr(String companyAddr) 							{ this.companyAddr = companyAddr; }
	public void setCompanyAddrDetail(String companyAddrDetail) 				{ this.companyAddrDetail = companyAddrDetail; }
	public void setCompanyEmail(String companyEmail) 						{ this.companyEmail = companyEmail; }
	public void setCompanyFax(String companyFax) 							{ this.companyFax = companyFax; }
	public void setCompanyEmployeeNum(int companyEmployeeNum) 				{ this.companyEmployeeNum = companyEmployeeNum; }
	public void setCompanyRegistrationDate(String companyRegistrationDate)	{ this.companyRegistrationDate = companyRegistrationDate; }
	public void setMember(Member member) 									{ this.member = member; }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryCompany [companyCode=");
		builder.append(companyCode);
		builder.append(", companyNum=");
		builder.append(companyNum);
		builder.append(", companySectors=");
		builder.append(companySectors);
		builder.append(", companyScale=");
		builder.append(companyScale);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyPhone=");
		builder.append(companyPhone);
		builder.append(", companyAddr=");
		builder.append(companyAddr);
		builder.append(", companyAddrDetail=");
		builder.append(companyAddrDetail);
		builder.append(", companyEmail=");
		builder.append(companyEmail);
		builder.append(", companyFax=");
		builder.append(companyFax);
		builder.append(", companyEmployeeNum=");
		builder.append(companyEmployeeNum);
		builder.append(", companyRegistrationDate=");
		builder.append(companyRegistrationDate);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

}
