package net.balgre.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OrderDetail {

	private Brand brand;
	private String deliveryNumber; //송장번호
	private int prodConfirm; 		// 1 일경우 상품 준비
	
	private List<OrderDetailProduct> ordDtProduct = new ArrayList<>();
}
