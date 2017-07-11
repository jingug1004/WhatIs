package net.balgre.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AppBasketProduct {
	
	private Product product;
	private List<AppBasketProductItem> basketProductItem = new ArrayList<>();
	private int totalPrice = 0;
	private int totalSalePrice = 0;
	private int totalMobilePrice = 0;
	private int freeDelivery = -1;
	private int deliveryPrice = 0;
	private int itemCheck = 0;
	private int viewFreeDelivery = -1;
	private int viewDeliveryPrice = 0;
}
