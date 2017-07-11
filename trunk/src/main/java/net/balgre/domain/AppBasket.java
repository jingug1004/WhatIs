package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class AppBasket {
	
	private String userId;
	private List<AppBasketSeller> appBasketSeller;
	private List<AppBasketSeller> soldOutSeller;
	private int total_price;
	private int mobilePrice;
	private Long salePrice=0L;
	private int total_delivery;
	private int mobile_delivery;
}
