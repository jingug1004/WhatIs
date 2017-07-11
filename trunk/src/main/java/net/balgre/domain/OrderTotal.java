package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderTotal {
	
	private String orderId;
	private String paymentName;
	private List<OrderProduct> orderProduct;
	private Long totalPrice;
	private int totalCount;
	private Long totalDelivery;
	private Long salePrice;
	private Long regDate;
	private List<OrderCoupon> orderCoupon;
}
