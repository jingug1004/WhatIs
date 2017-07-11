package net.balgre.domain;

import lombok.Data;

@Data
public class PointResponse {
	
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private int myPoint; // (integer, optional): 현재 포인트 ,
	private PageUserPoint pointList; // (Page«UserPoint», optional): 포인트 리스트 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private String timestamp; // (string, optional),
	private int totalPoint; // (integer, optional): 전체 포인트 ,
	private int usePoint; // (integer, optional): 사용 포인트

}
