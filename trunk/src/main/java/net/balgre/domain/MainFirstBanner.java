package net.balgre.domain;

import lombok.Data;

@Data
public class MainFirstBanner {
	
	private int fbId; // (integer, optional),
	private Product product; // (Product, optional): 상품 ,
	private String regDate; // (string, optional): 등록일 ,
	private int showType; // (integer, optional): 타입 1 : 메인 2 : 베스트 3 : New ,
	private String showYn; // (string, optional): 노출 여부 ,
	private int sort; // (integer, optional): 정렬 ,
	private String thumbnail; // (string, optional): 배너 이미지

}
