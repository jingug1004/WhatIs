package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.CouponUserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CouponRetroImpl {
	
	private CouponRetro couponRetro = null;
	
	public CouponRetroImpl() {
		this.couponRetro = this.create();
	}
	
	
	/*coupon list*/
	public CouponUserResponse myCouponList2(String token) {
		
		Call<CouponUserResponse> call = this.couponRetro.myCouponList(token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<CouponUserResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*coupon insert*/
	public CouponUserResponse myCouponInsert2(String token, String c_id) {
		
		Call<CouponUserResponse> call = this.couponRetro.myCouponInsert(token, 
				"application/x-www-form-urlencoded", c_id);
		
		try {
			Response<CouponUserResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected CouponRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
		
		return retrofit.create(CouponRetro.class);
	}
	
	protected GsonConverterFactory buildGsonConverter() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
	}
}
