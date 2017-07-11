package net.balgre.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {

	private boolean cancelStatus = true;		// 취소가능여부
	private int pointDis = 0;					// 포인트사용
	private int cpDis = 0;						// 쿠폰할인금액
	private int delivery = 0;					// 배송비
	private int payment = 0;					// 상품금액
	private int total = 0;						// 총결제금액
	private String vBankName;
	private String vBankNum;
	private long vBankDate;
	private String paymethod;
	private String status;		// ready paid cancelled failed
	private String buyer_name;
	private String buyer_tel;
	private String buyer_addr;
	private String note;
	private List<OrderDetail> orderDetail = new ArrayList<>();
}
