package com.kfarmstar.admin.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kfarmstar.admin.mapper.AdMapper;
import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.FileMapper;
import com.kfarmstar.dto.AdApply;
import com.kfarmstar.dto.AdPayType;
import com.kfarmstar.dto.AdPrice;
import com.kfarmstar.dto.AfterAdPay;
import com.kfarmstar.dto.BeforeAdPay;
import com.kfarmstar.dto.FileDto;
import com.kfarmstar.dto.Grade;
import com.kfarmstar.util.FileUtil;

@Service
@Transactional
public class AdService {
	
	private static final Logger log = LoggerFactory.getLogger(AdService.class);

	private AdMapper adMapper;
	private CommonMapper commonMapper;
	private FileUtil fileUtil;
	private FileMapper fileMapper;
	
	@Autowired
	public AdService(AdMapper adMapper, CommonMapper commonMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.adMapper = adMapper;
		this.commonMapper = commonMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	
	// 회원 아이디에 따른 등급별 혜택 조회
	public Grade getAdBenefitByGrade(String sessionId) {
		
		Grade grade = adMapper.getAdBenefitByGrade(sessionId);
		
		log.info("서비스 sellerGrade {}" + grade);
		log.info("서비스 sessionId {}" + sessionId);
		return grade;
	}
	
	
	// 광고 신청 등록 처리
	public int addAdApply(AdApply adApply, String sessionId, MultipartFile[] fileImage, String fileRealPath) {
		
		// ad_apply_code 자동 생성 (ad_apply_permit 테이블 등록)
		String adApplyCode = commonMapper.getNewCode("ad_apply_code", "ad_apply_permit");
		adApply.setAdApplyCode(adApplyCode);
		adApply.setMemberId(sessionId);	// 로그인한 세션아이디로 광고 신청 아이디값 넣어주기
		
		List<FileDto> fileList = fileUtil.parseFileInfo(fileImage, fileRealPath);
		
		fileMapper.addFiles(fileList);
		
		List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
		
		Map<String, String> paramMap = null;
		
		for(FileDto fileDto : fileList) {
			paramMap = new HashMap<String,String>();
			paramMap.put("referenceCode", adApplyCode);
			paramMap.put("fileIdx", fileDto.getFileIdx());
			paramList.add(paramMap);
		}
		
		fileMapper.addFilesContol(paramList);
		
		return adMapper.addAdApply(adApply);
	}
	
	
	// 광고 진행 중 or 광고 완료 목록
	public List<AdApply> getAdvertisingList(Map<String, Object> paramMap) {
		List<AdApply> advertisingList = adMapper.getAdvertisingList(paramMap);
		return advertisingList;
	}
	
	
	
	// 광고 신청 목록 조회
	public List<AdApply> getAdApplyList(Map<String, Object> paramMap) {
		
		List<AdApply> adApplyList = adMapper.getAdApplyList(paramMap);
		
		return adApplyList;
	}
	
	// 광고 신청 코드별 상세 정보 조회
	public AdApply getAdApplyByCode(String adApplyCode) {
		
		return adMapper.getAdApplyByCode(adApplyCode);
	}
	
	
	 // 광고 단가 목록 조회
	public List<AdPrice> getAdPriceList() {
		
		List<AdPrice> adPriceList = adMapper.getAdPriceList();
		return adPriceList;
	}
	
	
	// 광고 단가 코드별 정보 조회
	public AdPrice getAdPriceInfoByCode(String adPriceCode) {
		return adMapper.getAdPriceInfoByCode(adPriceCode);
	}
	
	
	
	// 광고 신청 상세 정보 수정
	public int modifyAdApply(AdApply adApply) {
		
		String startDate = adApply.getAdStartDate();	//datePicker 시작날짜
		String endDate = adApply.getAdEndDate();		//datePicker 종료날짜
		
		//문자열을 LocalDateTime객체로 만들기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);	
		LocalDate localStartDate = LocalDate.parse(startDate, formatter);
		LocalDate localEndDate = LocalDate.parse(endDate, formatter);
		
		//기간 구하기
		Period period = Period.between(localStartDate, localEndDate);
		int contractTerm = period.getDays()+1;
		String term = Integer.toString(contractTerm);
		
		adApply.setAdContractTerm(term); 
		return adMapper.modifyAdApply(adApply);
	}
	
	
	// 광고 단가 수정
	public int modifyAdPrice(AdPrice adPrice, String sessionId) {
		
		adPrice.setUpdateManagerId(sessionId);
		return adMapper.modifyAdPrice(adPrice);
	}
	
	
	 // 광고 단가 등록
	public int addAdPrice(AdPrice adPrice, String sessionId) {
		//pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("ad_price_code", "ad_price");
		  adPrice.setAdPriceCode(newCode);
		  adPrice.setMemberId(sessionId);
		  
		  int result = adMapper.addAdPrice(adPrice);
		  
		  return result; 
	}
	
	
	// 광고 승인 처리(신청 테이블 update & 결제전 테이블에 insert)
	public int adApproveUpdate(AdApply adApply, BeforeAdPay beforeAdPay, String sessionId, AdApply adApplyByCode, String adOriginPrice, String adDiscount) {
		log.info("sessionId {}" , sessionId);
		
		String adPaymentCode = commonMapper.getNewCode("ad_payment_code", "before_ad_payment");
		adApply.setManagerId(sessionId);
		beforeAdPay.setAdPaymentCode(adPaymentCode);
		beforeAdPay.setAdApplyCode(adApplyByCode.getAdApplyCode());
		beforeAdPay.setAdPriceCode(adApplyByCode.getAdPriceCode());
		beforeAdPay.setMemberId(adApplyByCode.getMemberId());
		beforeAdPay.setSellerGradeNum(adApplyByCode.getSellerGradeNum());
		beforeAdPay.setAdDiscount(adDiscount);
		beforeAdPay.setAdPaymentPrice(adOriginPrice); 
		beforeAdPay.setAdContractPrice(adApplyByCode.getAdContractPrice());
		beforeAdPay.setManagerId(sessionId);
		
		log.info("beforeAdPay : {}" + beforeAdPay);
		adMapper.adApproveUpdate(adApply);
		adMapper.addBeforeAdPay(beforeAdPay);
		return 0;
	}

	
	// 광고 승인 취소
	public int adApproveCancel(AdApply adApply, String sessionId) {
		log.info("sessionId {}" , sessionId);
		adApply.setManagerId(sessionId);
		return adMapper.adApproveCancel(adApply);
	}
	
	
	// 광고 결제 처리 및 진행상태 수정(결제완료)
	public int addAdPayment(String sessionId, AfterAdPay afterAdPay, AdPayType adPayType, AdApply adApply) {
		
		// 광고 결제 종류 등록 (ad_pay_type 테이블 등록)
		String adPayTypeCode = commonMapper.getNewCode("ad_pay_type_code", "ad_pay_type");
		adPayType.setAdPayTypeCode(adPayTypeCode);
		adPayType.setMemberId(sessionId);
		int result = adMapper.addAdPayType(adPayType);
		
		// 광고 결제 정보 등록 (after_ad_payment 테이블 등록)
		String adPayCompleteCode = commonMapper.getNewCode("ad_pay_complete_code", "after_ad_payment");
		afterAdPay.setAdPayCompleteCode(adPayCompleteCode);
		afterAdPay.setAdPayTypeCode(adPayType.getAdPayTypeCode());
		result += adMapper.addAfterAdPay(afterAdPay);
		
		// 광고 진행상태 결제완료 처리
		result += adMapper.adPayComplete(adApply);
		
		return result;
		
	}
	
	
	// 광고 신청 코드에 따라 결제 코드 조회
	public String getPayCodeByApplyCode(String adApplyCode) {
		
		return adMapper.getPayCodeByApplyCode(adApplyCode);
	}
	
	
	// 광고 신청번호에 따른 결제후 정보 조회
		public AfterAdPay adPayDetailByApplyCode(String adApplyCode) {
		return adMapper.adPayDetailByApplyCode(adApplyCode);
	}
	
}
