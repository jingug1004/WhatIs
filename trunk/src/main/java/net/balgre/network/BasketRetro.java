package net.balgre.network;

import net.balgre.domain.AppBasketResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface BasketRetro {

    @GET("/api/v2/basket/list")
    Call<AppBasketResponse> basket(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType
    );

    @POST("/api/v2/basket/add")
    Call<AppBasketResponse> basketAdd(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType,
            @Query("item_id") Long item_id2,
            @Query("item_count") Long item_count2

    );

    @POST("/api/v2/basket/delete")
    Call<AppBasketResponse> basketDelete(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType,
            @Query("basket_id") Long basket_id[]

    );
    
    @PUT("/api/v2/basket/update")
    Call<AppBasketResponse> basketUpdate(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType,
            @Query("basket_id") Long basket_id,
            @Query("item_count") int item_count
    );
    
    @PUT("/api/v2/basket/update_chk")
    Call<AppBasketResponse> basketUpdateCheck(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType,
            @Query("basket_id") Long basket_id[],
            @Query("checked") int checked
    );
    @PUT("/api/v2/basket/chk_all")
    Call<AppBasketResponse> basketUpdateCheckAll(
            @Header("X-Authorization") String token,
            @Header("Content-Type") String contentType,
            @Query("checked") int checked
    );
}
