package net.balgre.service;

import net.balgre.domain.ShippingResponse;

public interface ShippingService {
	
	public ShippingResponse shippingUpdate2(String name, String phone, String zipcode, String address1, String address2, String token);
	
	public ShippingResponse getShipping2(String token);

}
