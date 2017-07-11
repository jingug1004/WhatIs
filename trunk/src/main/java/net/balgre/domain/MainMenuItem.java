package net.balgre.domain;

import lombok.Data;

@Data
public class MainMenuItem {
	
	private int miId; // (integer, optional),
	private Product product; // (Product, optional): 상품 ,
	private int sort; // (integer, optional): 정렬

}
