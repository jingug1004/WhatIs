package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {

	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private String timestamp; // (string, optional)
	private String username;
	private OrderTotal orderTotal;
	private int myPoint;
	private int maxPoint;
	private List<CouponUser> overlap_cp;
	private List<Shipping> shipping;
}
