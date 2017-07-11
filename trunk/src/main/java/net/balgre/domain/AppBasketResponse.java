package net.balgre.domain;

import lombok.Data;

@Data
public class AppBasketResponse {
	
    private String message;
    private String resultCode;
    private String timestamp;
	private AppBasket basketList;
}

