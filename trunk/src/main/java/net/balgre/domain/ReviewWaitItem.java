package net.balgre.domain;

import lombok.Data;

@Data
public class ReviewWaitItem {
	
	private int itemId; // (integer, optional),
	private PaymentItem paymentItem; // (PaymentItem, optional): 구매

}
