package net.balgre.network;

import java.io.IOException;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderTotal;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.domain.Payments;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentRetroImpl {
    
    private PaymentRetro paymentRetro = null;
    
    public PaymentRetroImpl() {
    	this.paymentRetro = this.create();
    }
    
    
    public OrderTotal order(String token, List<PaymentOrder> itemList) {
    	Call<OrderTotal> call = this.paymentRetro.order(token, "application/json", itemList);
    	
    	try {
    		Response<OrderTotal> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    public OrderResponse getPayment(String token, String order_id) {
    	Call<OrderResponse> call = this.paymentRetro.getPayment(token, "application/x-www-form-urlencoded", order_id);
    	
    	try {
    		Response<OrderResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public PaymentResponse orderValid(String token, OrderValid orderValid) {
    	Call<PaymentResponse> call = this.paymentRetro.orderValid(token, "application/json", orderValid);
    	
    	try {
    		Response<PaymentResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public PaymentResponse orderComplete(String token, String paymentId, String impId, String mercId) {
    	Call<PaymentResponse> call = this.paymentRetro.orderComplete(token, "application/x-www-form-urlencoded", paymentId, impId, mercId);
    	
    	try {
    		Response<PaymentResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public List<Payments> myOrder(String token) {
    	Call<List<Payments>> call = this.paymentRetro.myOrder(token, "application/x-www-form-urlencoded");
    	
    	try {
    		Response<List<Payments>> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public Payments myOrderDetail(String token, String paymentId) {
    	Call<Payments> call = this.paymentRetro.myOrderDetail(token, "application/x-www-form-urlencoded", paymentId);
    	
    	try {
    		Response<Payments> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public PaymentResponse orderCancel(String token, String paymentId) {
    	Call<PaymentResponse> call = this.paymentRetro.myOrderCancel(token, "application/x-www-form-urlencoded", paymentId);
    	
    	try {
    		Response<PaymentResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    protected PaymentRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(PaymentRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }
}
