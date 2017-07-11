package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class MainMenu {
	
	private List<MainMenuItem> mainMenuItem; // (Array[MainMenuItem], optional): 메인 메뉴 상품 목록 ,
	private int mid; // (integer, optional),
	private String name; // (string, optional): 이름 ,
	private String regDate; // (string, optional): 등록일 ,
	private String showYn; // (string, optional): 노출 여부 ,
	private int sort; // (integer, optional): 정렬

}
