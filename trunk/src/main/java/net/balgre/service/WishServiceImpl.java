package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.WishListResponse;
import net.balgre.network.WishRetroImpl;

@Service
public class WishServiceImpl implements WishService {
	
	/*wish add*/
	@Override
	public WishListResponse wishAdd2(String token, long product_id) {
		// TODO Auto-generated method stub
		
		WishRetroImpl WRI = new WishRetroImpl();
		
		WishListResponse res = WRI.wishAdd2(token, product_id);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}
    
	
	/*wish list*/
	@Override
	public WishListResponse wishList2(String token) {
		// TODO Auto-generated method stub
		
		WishRetroImpl WRI = new WishRetroImpl();
		
		WishListResponse res = WRI.wishList2(token);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

    
	/*wish delete*/
	@Override
	public WishListResponse wishDelete2(String token, long wish_id) {
		// TODO Auto-generated method stub
		
		WishRetroImpl WRI = new WishRetroImpl();
		
		WishListResponse res = WRI.wishDelete2(token, wish_id);
		
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
