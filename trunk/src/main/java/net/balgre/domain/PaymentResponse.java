package net.balgre.domain;

import lombok.Data;

@Data
public class PaymentResponse {
	
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private Payments payment; // (Payments, optional): 결제 정보 
	private String resultCode; // (string, optional): 200 성공 99 실패 201 포인트부족 = ['200', '99', '101', '102', '102'],
	private String timestamp; // (string, optional)
	
}