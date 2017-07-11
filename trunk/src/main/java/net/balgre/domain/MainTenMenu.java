package net.balgre.domain;

import lombok.Data;

@Data
public class MainTenMenu {
	
	private String icon; // (string, optional): 아이콘 ,
	private String name; // (string, optional): 이름 ,
	private String regDate; // (string, optional): 등록일 ,
	private String showYn; // (string, optional): 노출 여부 ,
	private int sort; // (integer, optional): 정렬 ,
	private int tid; // (integer, optional): 출석체크: 0, 브랜드: 브랜드ID, 카테고리: 카테고리ID, 기획전: 기획전ID, 쿠폰: 0 ,
	private int tmId; // (integer, optional),
	private int tmType; // (integer, optional): 타입 - 0: 출석체크 1: 브랜드 2: 카테고리 3: 기획전, 4: 쿠폰

}
