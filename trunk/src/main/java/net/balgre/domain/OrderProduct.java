package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderProduct {
	
	private Long ordProdId;
	private Long productId;
	private String brandName;
	private String productName;
	private String thumbnail;
	private List<OrderItem> orderItem;
	
}
