package net.balgre.service;

import net.balgre.domain.WishListResponse;

public interface WishService {
	
	/*wish add*/
	public WishListResponse wishAdd2(String token, long product_id);
	
	/*wish list*/
	public WishListResponse wishList2(String token);
	
	/*wish delete*/
	public WishListResponse wishDelete2(String token, long wish_id);

}
