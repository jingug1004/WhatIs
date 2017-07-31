package net.balgre.network;


import java.util.List;

import net.balgre.domain.BestResponse;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CategoryResponse2;
import net.balgre.domain.PageBrand;
import net.balgre.domain.PageProduct;
import net.balgre.domain.Product;
import net.balgre.domain.ProductResponse;
import net.balgre.domain.ProductTimeSale;
import net.balgre.domain.RelationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductRetro {

    @GET("/api/product/best")
    Call<BestResponse> bestResponseGET();

    @GET("/api/product/category")
    Call<CategoryResponse> categoryResponseGET();
    
    @GET("/api/product/category2")
    Call<CategoryResponse2> categoryList2();

    @GET("/api/product/detail")
    Call<ProductResponse> detailGET(
            @Query("product_id") long product_id2
    );

    @GET("/api/product/list/{page}")
    Call<PageBrand> brandList(
            @Path("page") int page,
            @Query("brand_id") long brand_id,
            @Query("sort") int sort
    );

    /*@GET("/api/product/list/{parent}/{page}")
    Call<HashMap<String, Object>> listParentPageGET(
            @Path("parent") long parent2,
            @Path("page") int page2,
            @Query("menu_id") long menu_id2,
            @Query("sort") int sort2
    );*/

    @GET("/api/product/search")
    Call<List<Product>> searchGET(
            @Query("search") String search2
    );
    
    /*time sale list by minho*/
    @GET("/api/product/time")
    Call<List<ProductTimeSale>> timeSaleList(
    );
    
    /*balgeure box by minho*/
    @GET("/api/product/box")
    Call<List<Product>> balgeureBox(
    );
    
    /*new product by minho*/
    @GET("/api/product/list")
    Call<BestResponse> newProduct(
    );
    
    /*category by minho*/
    @GET("/api/product/category")
    Call<CategoryResponse> categoryList(
    );
 
    /*sub category by minho*/
    @GET("/api/product/sub_category")
    Call<CategoryResponse> subCategory(
        @Query("manu_id") long menu_id
    );
    
    /*category list by minho*/
    @GET("/api/product/list/{parent}/{page}")
    Call<PageProduct> categoryList(
        @Path("parent") long parent,
        @Path("page") int page,
        @Query("menu_id") long menu_id,
        @Query("sort") int sort
    );
    
    @GET("/api/product/relation")
    Call<RelationResponse> relationProduct(
        @Query("product_id") long product_id	
    );

}
