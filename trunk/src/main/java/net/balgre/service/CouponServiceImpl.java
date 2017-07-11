package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.CouponUserResponse;
import net.balgre.network.CouponRetroImpl;

@Service
public class CouponServiceImpl implements CouponService {

	/*coupon list*/
	@Override
	public CouponUserResponse myCouponList2(String token) {
		// TODO Auto-generated method stub
		
		CouponRetroImpl CRI = new CouponRetroImpl();
		
		CouponUserResponse res = CRI.myCouponList2(token);
		
		if (res == null) {
			
			return null;
		}
		
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

	
	/*coupon insert*/
	@Override
	public CouponUserResponse myCouponInsert2(String token, String c_id) {
		// TODO Auto-generated method stub
		
		CouponRetroImpl CRI = new CouponRetroImpl();
		
		CouponUserResponse res = CRI.myCouponInsert2(token, c_id);
		
//		if (res == null) {
//			
//			return null;
//		}
		
//		if (res.getResultCode().equals("200")) {
//			
			return res;
//		} else {
//			
//			return null;
//		}
	}
}
