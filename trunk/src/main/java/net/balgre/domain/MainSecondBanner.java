package net.balgre.domain;

import lombok.Data;

@Data
public class MainSecondBanner {
	
	private String regDate; // (string, optional): 등록일 ,
	private int sbId; // (integer, optional),
	private int sbType; // (integer, optional): 배너타입 - 0: 출석체크 1: 브랜드 2: 상품 3: 기획전, 4: 쿠폰 ,
	private String showYn; // (string, optional): 노출 여부 ,
	private int sort; // (integer, optional): 정렬 ,
	private String thumbnail; // (string, optional): 배너 이미지 ,
	private int tid; // (integer, optional): 출석체크: 이벤트ID, 브랜드: 브랜드ID, 상품: 상품ID, 기획전: 기획전ID, 쿠폰: 이벤트ID

}
