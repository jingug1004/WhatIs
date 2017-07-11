package net.balgre.domain;

import lombok.Data;

@Data
public class PlanProduct {
	
	private int ppId; // (integer, optional): 기획전 상품 ID ,
	private Product product; // (Product, optional): 상품

}
