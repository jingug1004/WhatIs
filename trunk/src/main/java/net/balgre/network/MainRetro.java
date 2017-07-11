package net.balgre.network;


import net.balgre.domain.*;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MainRetro {
    @GET("/api/main")
    Call<MainResponse> getMain();

//    상품(Product)에 Retrofit 있음!
//    @GET("/api/main")
//    Call<MainFirstBanner> getMainFirstBanner();
//
//    @GET("/api/main")
//    Call<MainMenu> getMainMenu();
//
//    @GET("/api/main")
//    Call<MainSecondBanner> getMainSecondBanner();
//
//    @GET("/api/main")
//    Call<MainTenMenu> getMainTenMenu();

    @GET("/api/main")
    Call<Product> getProduct();

    @GET("/api/main")
    Call<MainMenuItem> getMainMenuItem();

    @GET("/api/main")
    Call<Brand> getBrand();

    @GET("/api/main")
    Call<ProductDelivery> getProductDelivery();

    @GET("/api/main")
    Call<User> getUser();

    @GET("/api/main")
    Call<DeliveryCompany> getDeliveryCompany();

    @GET("/api/main")
    Call<UserRole> getUserRole();

    @GET("/api/main")
    Call<Id> getId();


//	@GET("/api/product/detail")
//    Call<Product> getProductDetail(
//            @Query("product_id") Long productId
//    );

}
