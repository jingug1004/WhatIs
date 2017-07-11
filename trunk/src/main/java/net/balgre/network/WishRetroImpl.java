package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.WishListResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WishRetroImpl {
	
	private WishRetro wishRetro = null;
	
	public WishRetroImpl() {
		this.wishRetro = this.create();
	}
	
	
	/*wish add*/
	public WishListResponse wishAdd2(String token, long product_id) {
		
		Call<WishListResponse> call = this.wishRetro.wishAdd(token, 
				"application/x-www-form-urlencoded", product_id);
		
		try {
			Response<WishListResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*wish list*/
	public WishListResponse wishList2(String token) {
		
		Call<WishListResponse> call = this.wishRetro.wishList(token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<WishListResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*wish delete*/
	public WishListResponse wishDelete2(String token, long wish_id) {
		
		Call<WishListResponse> call = this.wishRetro.wishDelete(token, 
				"application/x-www-form-urlencoded", wish_id);
		
		try {
			Response<WishListResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected WishRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
		return retrofit.create(WishRetro.class);
	}
	
	protected GsonConverterFactory buildGsonConverter() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
	}

}
