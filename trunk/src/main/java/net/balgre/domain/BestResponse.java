package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class BestResponse {
	
	private List<MainFirstBanner> firstBanner; // (Array[MainFirstBanner], optional): 상단 배너 ,
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private List<Product> productList; // (Array[Product], optional): 신규 또는 베스트 상품 ,
	private String resultCode; // (string, optional): 200 성공 99 업데이트 필요 = ['200', '99'],
	private String timestamp; // (string, optional)

}
