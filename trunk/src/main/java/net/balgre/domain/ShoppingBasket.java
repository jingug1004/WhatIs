package net.balgre.domain;

import lombok.Data;

//장바구니
@Data
public class ShoppingBasket {

	private Long basketId;
	private User user;
	private ProductItem productItem;
	private int itemCount;
	private int itemCheck = 1;
	private Long regDate;
}
