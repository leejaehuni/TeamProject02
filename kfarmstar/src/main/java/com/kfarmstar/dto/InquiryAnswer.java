package com.kfarmstar.dto;

/**
 * DB정보
 * Table	: inquiry_answer
 * FK Table	: inquiry_category
 * 			  member
 */
public class InquiryAnswer {
	//기본키
	private String inquiryNum;
	
	//기본 컬럼
	private String inquiryTitle;
	private String inquiryDetail;
	private String inquiryRegistrationId;
	private String inquiryRegistrationName;
	private String addInquiryDate;
	private String answerState;
	private String answerDetail;
	private String respondentId;
	private String answerDate;
	
	//외래키
	private InquiryCategory inquiryCategory;
	private Member member;
	
	public String getInquiryNum() 											{ return inquiryNum; }
	public String getInquiryTitle() 										{ return inquiryTitle; }
	public String getInquiryDetail() 										{ return inquiryDetail; }
	public String getInquiryRegistrationId() 								{ return inquiryRegistrationId; }
	public String getInquiryRegistrationName() 								{ return inquiryRegistrationName; }
	public String getAddInquiryDate()										{ return addInquiryDate; }
	public String getAnswerState() 											{ return answerState; }
	public String getAnswerDetail() 										{ return answerDetail; }
	public String getRespondentId() 										{ return respondentId; }
	public String getAnswerDate() 											{ return answerDate; }
	public InquiryCategory getInquiryCategory() 							{ return inquiryCategory; }
	public Member getMember() 												{ return member; }
	
	public void setInquiryNum(String inquiryNum) 							{ this.inquiryNum = inquiryNum; }
	public void setInquiryTitle(String inquiryTitle) 						{ this.inquiryTitle = inquiryTitle; }
	public void setInquiryDetail(String inquiryDetail) 						{ this.inquiryDetail = inquiryDetail; }
	public void setInquiryRegistrationId(String inquiryRegistrationId) 		{ this.inquiryRegistrationId = inquiryRegistrationId; }
	public void setInquiryRegistrationName(String inquiryRegistrationName)	{ this.inquiryRegistrationName = inquiryRegistrationName; }
	public void setAddInquiryDate(String addInquiryDate) 					{ this.addInquiryDate = addInquiryDate; }
	public void setAnswerState(String answerState) 							{ this.answerState = answerState; }
	public void setAnswerDetail(String answerDetail) 						{ this.answerDetail = answerDetail; }
	public void setRespondentId(String respondentId) 						{ this.respondentId = respondentId; }
	public void setAnswerDate(String answerDate) 							{ this.answerDate = answerDate; }
	public void setInquiryCategory(InquiryCategory inquiryCategory) 		{ this.inquiryCategory = inquiryCategory; }
	public void setMember(Member member) 									{ this.member = member; }
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InquiryAnswer [inquiryNum=");
		builder.append(inquiryNum);
		builder.append(", inquiryTitle=");
		builder.append(inquiryTitle);
		builder.append(", inquiryDetail=");
		builder.append(inquiryDetail);
		builder.append(", inquiryRegistrationId=");
		builder.append(inquiryRegistrationId);
		builder.append(", inquiryRegistrationName=");
		builder.append(inquiryRegistrationName);
		builder.append(", addInquiryDate=");
		builder.append(addInquiryDate);
		builder.append(", answerState=");
		builder.append(answerState);
		builder.append(", answerDetail=");
		builder.append(answerDetail);
		builder.append(", respondentId=");
		builder.append(respondentId);
		builder.append(", answerDate=");
		builder.append(answerDate);
		builder.append(", inquiryCategory=");
		builder.append(inquiryCategory);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
