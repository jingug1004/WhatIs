package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MemberLeaveRetroImpl {
	
	
	private MemberLeaveRetro memberLeaveRetro = null;
	
	public MemberLeaveRetroImpl() {
		this.memberLeaveRetro = this.create();
	}
	
	/*member leave*/
	public UserResponse memberLeave(String token, String reason) {
		
		Call<UserResponse> call = this.memberLeaveRetro.memberLeave(token, 
				"application/x-www-form-urlencoded", reason);
		
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
	
	
	protected MemberLeaveRetro create() {

		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

		return retrofit.create(MemberLeaveRetro.class);
	}

	protected GsonConverterFactory buildGsonConverter() {
		GsonBuilder gsonBuilder = new GsonBuilder();

		Gson myGson = gsonBuilder.create();

		return GsonConverterFactory.create(myGson);
	}

}
