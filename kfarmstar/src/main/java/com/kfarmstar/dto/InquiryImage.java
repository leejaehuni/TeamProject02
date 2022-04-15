package com.kfarmstar.dto;

/**
 * DB정보
 * Table	: inquiry_image
 * FK Table	: inquiry_answer
 */
public class InquiryImage {
	//기본키
	private String imageNum;
	
	//기본 컬럼
	private String imageFileName;
	
	//외래키
	private InquiryAnswer inquiryAnswer;

	public String getImageNum() 								{ return imageNum; }
	public String getImageFileName() 							{ return imageFileName; }
	public InquiryAnswer getInquiryAnswer() 					{ return inquiryAnswer; }

	public void setImageNum(String imageNum) 					{ this.imageNum = imageNum; }
	public void setImageFileName(String imageFileName) 			{ this.imageFileName = imageFileName; }
	public void setInquiryAnswer(InquiryAnswer inquiryAnswer)	{ this.inquiryAnswer = inquiryAnswer; }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InquiryImage [imageNum=");
		builder.append(imageNum);
		builder.append(", imageFileName=");
		builder.append(imageFileName);
		builder.append(", inquiryAnswer=");
		builder.append(inquiryAnswer);
		builder.append("]");
		return builder.toString();
	}
	
}
