package net.balgre.network;

import net.balgre.domain.WishListResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WishRetro {
	
	/*wish add*/
	@POST("/api/v1/wish/add")
	Call<WishListResponse> wishAdd(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType,
	    @Query("product_id") long product_id
	);
	
	/*wish list*/
	@GET("/api/v1/wish/list")
	Call<WishListResponse> wishList(
		@Header("X-Authorization") String token,
		@Header("Content-Type") String contentType
	);
	
	/*wish delete*/
	@DELETE("/api/v1/wish/delete")
	Call<WishListResponse> wishDelete(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType,
	    @Query("wish_id") long wish_id
	);
	

}
