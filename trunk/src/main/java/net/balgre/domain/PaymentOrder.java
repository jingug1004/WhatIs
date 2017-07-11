package net.balgre.domain;

import lombok.Data;

@Data
public class PaymentOrder {

	private String itemId;
	private int itemPrice;
	private long itemCnt;
}
