package net.balgre.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OrderDetailProduct {

	private Product product;
	private List<PaymentItem> itemList = new ArrayList<>();
}
