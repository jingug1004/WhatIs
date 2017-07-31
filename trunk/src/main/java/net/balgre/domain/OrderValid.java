package net.balgre.domain;

import lombok.Data;

@Data
public class OrderValid {

	private int totalPayment;
	private String orderId;
	private Long orderCpId;
	private String overlapCpId;
	private int overlapCpDis;
	private int usePoint; 
	private String name;
	private String phone;
	private String zipcode;
	private String address1;
	private String address2;
	private String memo;
	private String refund_holder;
	private String refund_bank;	
	private String refund_account;
	private String os = "W";
}
