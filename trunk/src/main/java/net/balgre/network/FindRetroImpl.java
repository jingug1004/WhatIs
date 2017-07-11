package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindRetroImpl {
	
	
	private FindRetro findRetro = null;
	
	public FindRetroImpl() {
		this.findRetro = this.create();
	}
	
	
	/*find id*/
	public UserResponse findId2(String name, String phone) {
		
		Call<UserResponse> call = this.findRetro.findId(name, phone);
		
		try {
			Response<UserResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*find password email*/
	public CommonResponse findPwEmail2(String email, String name) {
		
		Call<CommonResponse> call = this.findRetro.findPwEmail(email, name);
		
		try {
			Response<CommonResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*find password phone*/
	public CommonResponse findPwPhone2(String email, String phone) {
		
		Call<CommonResponse> call = this.findRetro.findPwPhone(email, phone);
		
		try {
			Response<CommonResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected FindRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
		return retrofit.create(FindRetro.class);
	}
	
	protected GsonConverterFactory buildGsonConverter() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
	}

}
