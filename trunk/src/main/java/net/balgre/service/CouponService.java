package net.balgre.service;

import net.balgre.domain.CouponUserResponse;

public interface CouponService {

    /*coupon list*/
	public CouponUserResponse myCouponList2(String token);
	
	/*coupon insert*/
	public CouponUserResponse myCouponInsert2(String token, String c_id);
}
