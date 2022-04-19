package com.kfarmstar.dto;

import java.util.List;

public class AdApply {
	
	private String adApplyCode;
	private String adPriceCode;
	private String memberId;
	private String sellerGradeNum;
	private String adApplyTitle;
	private String adCate;
	private String adContractPrice;
	private String adApplyDate;
	private String adStartDate;
	private String adEndDate;
	private String adContractTerm;
	private String adGoodsUrl;
	private String adContent;
	private String adImg;
	private String adPermitState;
	private String managerId;
	private String adPermitDate;
	
	
	private AdPrice adPrice;
	private Member member;
	private SellerGrade sellerGrade;
	
	private List<FileDto> fileList;

	public String getAdApplyCode() {
		return adApplyCode;
	}

	public void setAdApplyCode(String adApplyCode) {
		this.adApplyCode = adApplyCode;
	}

	public String getAdPriceCode() {
		return adPriceCode;
	}

	public void setAdPriceCode(String adPriceCode) {
		this.adPriceCode = adPriceCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSellerGradeNum() {
		return sellerGradeNum;
	}

	public void setSellerGradeNum(String sellerGradeNum) {
		this.sellerGradeNum = sellerGradeNum;
	}

	public String getAdApplyTitle() {
		return adApplyTitle;
	}

	public void setAdApplyTitle(String adApplyTitle) {
		this.adApplyTitle = adApplyTitle;
	}

	public String getAdCate() {
		return adCate;
	}

	public void setAdCate(String adCate) {
		this.adCate = adCate;
	}

	public String getAdContractPrice() {
		return adContractPrice;
	}

	public void setAdContractPrice(String adContractPrice) {
		this.adContractPrice = adContractPrice;
	}

	public String getAdApplyDate() {
		return adApplyDate;
	}

	public void setAdApplyDate(String adApplyDate) {
		this.adApplyDate = adApplyDate;
	}

	public String getAdStartDate() {
		return adStartDate;
	}

	public void setAdStartDate(String adStartDate) {
		this.adStartDate = adStartDate;
	}

	public String getAdEndDate() {
		return adEndDate;
	}

	public void setAdEndDate(String adEndDate) {
		this.adEndDate = adEndDate;
	}

	public String getAdContractTerm() {
		return adContractTerm;
	}

	public void setAdContractTerm(String adContractTerm) {
		this.adContractTerm = adContractTerm;
	}

	public String getAdGoodsUrl() {
		return adGoodsUrl;
	}

	public void setAdGoodsUrl(String adGoodsUrl) {
		this.adGoodsUrl = adGoodsUrl;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public String getAdImg() {
		return adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public String getAdPermitState() {
		return adPermitState;
	}

	public void setAdPermitState(String adPermitState) {
		this.adPermitState = adPermitState;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getAdPermitDate() {
		return adPermitDate;
	}

	public void setAdPermitDate(String adPermitDate) {
		this.adPermitDate = adPermitDate;
	}

	public AdPrice getAdPrice() {
		return adPrice;
	}

	public void setAdPrice(AdPrice adPrice) {
		this.adPrice = adPrice;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public SellerGrade getSellerGrade() {
		return sellerGrade;
	}

	public void setSellerGrade(SellerGrade sellerGrade) {
		this.sellerGrade = sellerGrade;
	}

	public List<FileDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileDto> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "AdApply [adApplyCode=" + adApplyCode + ", adPriceCode=" + adPriceCode + ", memberId=" + memberId
				+ ", sellerGradeNum=" + sellerGradeNum + ", adApplyTitle=" + adApplyTitle + ", adCate=" + adCate
				+ ", adContractPrice=" + adContractPrice + ", adApplyDate=" + adApplyDate + ", adStartDate="
				+ adStartDate + ", adEndDate=" + adEndDate + ", adContractTerm=" + adContractTerm + ", adGoodsUrl="
				+ adGoodsUrl + ", adContent=" + adContent + ", adImg=" + adImg + ", adPermitState=" + adPermitState
				+ ", managerId=" + managerId + ", adPermitDate=" + adPermitDate + ", adPrice=" + adPrice + ", member="
				+ member + ", sellerGrade=" + sellerGrade + ", fileList=" + fileList + "]";
	}
	
	
	
	
}
