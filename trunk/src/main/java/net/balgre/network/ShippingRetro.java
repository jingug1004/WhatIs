package net.balgre.network;

import net.balgre.domain.ShippingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ShippingRetro {
	
	@PUT("/api/v1/shipping/shipping")
	Call<ShippingResponse> shippingUpdate(
	    @Query("name") String name,
	    @Query("phone") String phone,
	    @Query("zipcode") String zipcode,
	    @Query("address1") String address1,
	    @Query("address2") String address2,
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);
	
	@GET("/api/v1/shipping/shipping/info")
	Call<ShippingResponse> getShipping(
	    @Header("X-authorization") String token,
	    @Header("Content-Type") String contentType
	);

}
