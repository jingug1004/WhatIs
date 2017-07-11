package net.balgre.domain;

import lombok.Data;

@Data
public class ProductDetail {
	
	private Product product;
	private String id;
	private Category category;

}
