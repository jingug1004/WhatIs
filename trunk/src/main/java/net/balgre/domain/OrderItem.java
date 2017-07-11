package net.balgre.domain;

import lombok.Data;

@Data
public class OrderItem {

	private Long ordItemId;
	private Long itemId;
	private Long productId;
	private String itemName;
	private int itemCount;
	private int price;
	private int delivery;
}
