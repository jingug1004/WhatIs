package net.balgre.network;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.MyReviewResponse;
import net.balgre.domain.PageReview;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ReviewRetro {

    /*review insert by minho*/
    @POST("/api/v1/review/add")
    Call<CommonResponse> reviewInsert (
            @Query("order_id") long order_id,
            @Query("files") String[] files,
            @Query("content") String content,
            @Query("star") Integer star,
            @Query("skin_type") Integer skin_type,
            @Header("X-Authorization") String token,
    	    @Header("Content-Type") String contentType
    );
    
    @POST("/api/v1/review/myreview")
    Call<MyReviewResponse> PossibleReview (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType
    );
    
    @GET("/api/review/list/{page}")
    Call<PageReview> reviewList (
    		@Path("page") int page,
    		@Query("product_id") long product_id,
    		@Query("photo") int photo,
    		@Query("sort") int sort
    );
}
