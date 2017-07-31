package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class NaverPayProduct {
	
	private String id;
	private String name;
	private int basePrice;
	private String infoUrl;
	private String imageUrl;
	private List<NaverPayOption> options;
	private NaverPayShipping shipping;
}
