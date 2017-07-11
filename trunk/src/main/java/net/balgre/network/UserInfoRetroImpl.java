package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserInfoRetroImpl {
	
    private UserInfoRetro userInfoRetro = null;
	
	public UserInfoRetroImpl() {
		this.userInfoRetro = this.create();
	}
	
	
	/*user info by minho*/
	public UserResponse getUserInfo2(String token) {
		
		Call<UserResponse> call = this.userInfoRetro.getUserInfo(token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<UserResponse> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			}
		} catch (IOException e) {
		}
		return null;
	}
	
	
	protected UserInfoRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(UserInfoRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }
}
