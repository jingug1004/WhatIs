package net.balgre.domain;

import lombok.Data;

@Data
public class OrderCoupon {

	private Long orderCpId;
	private Coupon coupon;
	private Long maxDis;
	private Long ordProdId;
	
}
