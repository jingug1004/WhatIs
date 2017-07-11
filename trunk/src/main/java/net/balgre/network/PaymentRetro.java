package net.balgre.network;

import java.util.List;

import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderTotal;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.domain.Payments;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PaymentRetro {

    @POST("/api/v2/payment/order")
    Call<OrderTotal> order (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Body List<PaymentOrder> item
    );
    
    
    @GET("/api/v2/payment/order")
    Call<OrderResponse> getPayment(
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Query("orderId") String orderId
    );
    
    @POST("/api/v2/payment/order_valid")
    Call<PaymentResponse> orderValid (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Body OrderValid orderValid
    );
    
    @POST("/api/v2/payment/order_complete")
    Call<PaymentResponse> orderComplete (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Query("payment_id") String payment_id,
			@Query("imp_uid") String imp_uid, 
			@Query("merchant_uid") String merchant_uid
    );
    
    @POST("/api/v2/payment/list")
    Call<List<Payments>> myOrder (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType
    );
    
    @POST("/api/v2/payment/payment")
    Call<Payments> myOrderDetail (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Query("payment_id") String payment_id
    );
    
    @POST("/api/v2/payment/cancel")
    Call<PaymentResponse> myOrderCancel (
    		@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Query("payment_id") String payment_id
    );
}
