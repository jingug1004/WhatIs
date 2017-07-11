package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.NaverAccessToken;
import net.balgre.domain.NaverUserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NaverClient {
	
	private static final String API_URL = "https://nid.naver.com";
	private Naver naver = null;
	
	public NaverClient(String api_key) {
		this.naver = this.create();
	}

	public NaverAccessToken getAuth(String grant_type, String state, String code) {
		Call<NaverAccessToken> call = this.naver.token(BalgreConstants.NAVER_CLIENT_ID, BalgreConstants.NAVER_SECRET_ID, grant_type, state, code);
		
		try {
			Response<NaverAccessToken> response = call.execute();
			if ( response.isSuccessful() ) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public NaverUserResponse getUserData(String access_token) {
		Call<NaverUserResponse> call = this.naver.userData(BalgreConstants.TOKEN_SUFFIX+access_token);
		
		try {
			Response<NaverUserResponse> response = call.execute();
			if ( response.isSuccessful() ) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected Naver create() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(API_URL)
				.addConverterFactory(buildGsonConverter())
				.build();
		
		return retrofit.create(Naver.class);
	}
	
	
	protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}
