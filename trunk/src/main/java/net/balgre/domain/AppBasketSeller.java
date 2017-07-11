package net.balgre.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AppBasketSeller {
	private User seller;
	private Brand brand;
	private List<AppBasketProduct> basketProduct = new ArrayList<>();
	private int totalPrice = 0;
	private int totalSalePrice = 0;
	private int totalMobilePrice = 0;
	private int freeDelivery = -1;
	private int deliveryPrice = 0;
}
