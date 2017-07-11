package net.balgre.domain;

import lombok.Data;

@Data
public class AppBasketProductItem {
	private ShoppingBasket shoppingBasket;
	private int price;
	private int salePrice;
	private int mobilePrice;
	
}
