package net.balgre.domain;

import lombok.Data;

@Data
public class ShippingResponse {
	
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private Shipping shipping; // (Shipping, optional): 기본배송지 ,
	private String timestamp; // (string, optional)

}
