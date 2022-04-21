package com.kfarmstar.dto;

/**
 * DB정보
 * Table	: inquiry_category
 */
public class InquiryCategory {
	//기본키
	private String categoryNum;
	
	//기본 컬럼
	private String categoryName;
	private String categoryRegistrationId;
	private String addCategoryDate;
	private String modifyCategoryDate;
	
	public String getCategoryNum() 											{ return categoryNum; }
	public String getCategoryName() 										{ return categoryName; }
	public String getCategoryRegistrationId() 								{ return categoryRegistrationId; }
	public String getAddCategoryDate() 										{ return addCategoryDate; }
	public String getModifyCategoryDate() 									{ return modifyCategoryDate; }
	
	public void setCategoryNum(String categoryNum) 							{ this.categoryNum = categoryNum; }
	public void setCategoryName(String categoryName) 						{ this.categoryName = categoryName; }
	public void setCategoryRegistrationId(String categoryRegistrationId)	{ this.categoryRegistrationId = categoryRegistrationId; }
	public void setAddCategoryDate(String addCategoryDate) 					{ this.addCategoryDate = addCategoryDate; }
	public void setModifyCategoryDate(String modifyCategoryDate)			{ this.modifyCategoryDate = modifyCategoryDate; }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InquiryCategory [categoryNum=");
		builder.append(categoryNum);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", categoryRegistrationId=");
		builder.append(categoryRegistrationId);
		builder.append(", addCategoryDate=");
		builder.append(addCategoryDate);
		builder.append(", modifyCategoryDate=");
		builder.append(modifyCategoryDate);
		builder.append("]");
		return builder.toString();
	}
	
}
