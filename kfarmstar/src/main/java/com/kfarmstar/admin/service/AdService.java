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
import com.kfarmstar.dto.AdPrice;
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
	
	/**
	 * 광고 신청 등록 처리
	 */
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
	
	
	/**
	 * 광고 진행 중 or 광고 완료 목록
	 */
	public List<AdApply> getAdvertisingList() {
		List<AdApply> advertisingList = adMapper.getAdvertisingList();
		return advertisingList;
	}
	
	
	
	/**
	 * 광고 신청 목록 조회 
	 * @param paramMap 
	 */
	public List<AdApply> getAdApplyList(Map<String, Object> paramMap) {
		
		List<AdApply> adApplyList = adMapper.getAdApplyList(paramMap);
		
		return adApplyList;
	}
	
	// 상품 코드별 상세 정보 조회
	public AdApply getAdApplyByCode(String adApplyCode) {
		
		return adMapper.getAdApplyByCode(adApplyCode);
	}
	
	
	
	
	/**
	 * 광고 단가 목록 조회
	 */
	public List<AdPrice> getAdPriceList() {
		
		List<AdPrice> adPriceList = adMapper.getAdPriceList();
		return adPriceList;
	}
	

	/**
	 * 광고단가 코드별 정보 조회
	 */
	public AdPrice getAdPriceInfoByCode(String adPriceCode) {
		return adMapper.getAdPriceInfoByCode(adPriceCode);
	}
	
	/**
	 * 광고 신청 상세 정보 수정
	 */
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
		
		adApply.setAdContractTerm(term); // 계약기간 dto에 넣어주기
		return adMapper.modifyAdApply(adApply);
	}
	
	
	/**
	 * 광고 단가 수정
	 */
	public int modifyAdPrice(AdPrice adPrice) {
		
		adPrice.setUpdateManagerId("id003"); //임의로 넣은 수정자 아이디
		return adMapper.modifyAdPrice(adPrice);
	}
	
	
	/**
	 * 광고 단가 등록
	 */
	public int addAdPrice(AdPrice adPrice) {
		//pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("ad_price_code", "ad_price");
		  adPrice.setAdPriceCode(newCode);
		  adPrice.setMemberId("id002"); //임의로 넣은 등록자 아이디
		  
		  int result = adMapper.addAdPrice(adPrice);
		  
		  return result; 
	}
	
	/**
	 * 광고 승인 처리(신청 테이블 update & 결제전 테이블에 insert)
	 * @param adOriginPrice 
	 * @param adDiscount 
	 */
	public int adApproveUpdate(AdApply adApply, BeforeAdPay beforeAdPay, String sessionId, AdApply adApplyByCode, String adOriginPrice, String adDiscount) {
		log.info("sessionId {}" , sessionId);
		
		String adPaymentCode = commonMapper.getNewCode("ad_payment_code", "before_ad_payment");
		adApply.setManagerId(sessionId);
		beforeAdPay.setAdPaymentCode(adPaymentCode);
		beforeAdPay.setAdApplyCode(adApplyByCode.getAdApplyCode());
		beforeAdPay.setAdPriceCode(adApplyByCode.getAdPriceCode());
		beforeAdPay.setMemberId(adApplyByCode.getMemberId());
		beforeAdPay.setSellerGradeNum(adApplyByCode.getSellerGradeNum());
		/* 계산못하겠어서 ㅇ일단 null값허용으로 변경해둠
		 * 
		 * 
		 */
		beforeAdPay.setAdDiscount(adDiscount);
		beforeAdPay.setAdPaymentPrice(adOriginPrice); 
		beforeAdPay.setAdContractPrice(adApplyByCode.getAdContractPrice());
		beforeAdPay.setManagerId(sessionId);
		
		log.info("beforeAdPay : {}" + beforeAdPay);
		adMapper.adApproveUpdate(adApply);
		adMapper.addBeforeAdPay(beforeAdPay);
		return 0;
		
	}

	//광고 승인 취소
	public int adApproveCancle(AdApply adApply, String sessionId) {
		log.info("sessionId {}" , sessionId);
		adApply.setManagerId(sessionId);
		return adMapper.adApproveCancle(adApply);
	}
	
}
