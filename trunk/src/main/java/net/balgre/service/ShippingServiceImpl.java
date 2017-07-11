package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.ShippingResponse;
import net.balgre.network.ShippingRetroImpl;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Override
	public ShippingResponse shippingUpdate2(String name, String phone, String zipcode, String address1, String address2, String token) {
		// TODO Auto-generated method stub
		
		ShippingRetroImpl SRI = new ShippingRetroImpl();
		
		ShippingResponse res = SRI.shippingUpdate2(name, phone, zipcode, address1, address2, token);
		
		if (res == null) {
			return null;
		}
		
		if(res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

	@Override
	public ShippingResponse getShipping2(String token) {
		// TODO Auto-generated method stub
		
		ShippingRetroImpl SRI = new ShippingRetroImpl();
		
		ShippingResponse res = SRI.getShipping2(token);
		
		if (res == null) {
			
			return null;
		}
		
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

}
