package net.balgre.network;

import net.balgre.domain.CouponUserResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface CouponRetro {

    /*coupon list*/
	@POST("/api/v1/coupon/my_coupon")
	Call<CouponUserResponse> myCouponList(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);
	
	/*coupon insert*/
    @PUT("/api/v1/coupon/use")
    Call<CouponUserResponse> myCouponInsert(
        @Header("X-Authorization") String token,
        @Header("Content-Type") String contentType,
        @Query("c_id") String c_id
    );
}
