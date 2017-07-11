package net.balgre.domain;

import lombok.Data;

@Data
public class Shipping {
	
	private String address1; // (string, optional): 주소1 ,
	private String address2; // (string, optional): 주소2 ,
	private String defAddr; // (string, optional): 기본배송지 ,
	private String name; // (string, optional): 이름 ,
	private String phone; // (string, optional): 전화번호 ,
	private String regDate; // (string, optional): 등록일 ,
	private int shipId; // (integer, optional): 배송지 ID ,
	private String zipcode; // (string, optional): 우편번호

}
