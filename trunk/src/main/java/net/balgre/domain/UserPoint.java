package net.balgre.domain;

import lombok.Data;

@Data
public class UserPoint {
	
	private int id; // (integer, optional),
	private String note; // (string, optional): 비고 ,
	private int point; // (integer, optional): 포인트 ,
	private String regDate; // (string, optional): 획득일

}
