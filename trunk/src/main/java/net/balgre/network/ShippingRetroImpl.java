package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.ShippingResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShippingRetroImpl {
	
	
	private ShippingRetro shippingRetro = null;
	
	public ShippingRetroImpl() {
		this.shippingRetro = this.create();
	}
	
	
	/*shipping update*/
	public ShippingResponse shippingUpdate2(String name, String phone, String zipcode, String address1, String address2, String token) {
		
		Call<ShippingResponse> call = this.shippingRetro.shippingUpdate(name, phone, zipcode, address1, address2,
				token, "application/x-www-form-urlencoded");
		
		try {
			Response<ShippingResponse> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*get shipping*/
	public ShippingResponse getShipping2(String token) {
		
		Call<ShippingResponse> call = this.shippingRetro.getShipping(token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<ShippingResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected ShippingRetro create() {
		
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
		
		return retrofit.create(ShippingRetro.class);
	}
	
	protected GsonConverterFactory buildGsonConverter() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		Gson myGson = gsonBuilder.create();
		
		return GsonConverterFactory.create(myGson);
	}

}
