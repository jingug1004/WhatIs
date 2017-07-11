package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrivacyRetroImpl {
	
    private PrivacyRetro privacyRetro = null;
	
	public PrivacyRetroImpl() {
		this.privacyRetro = this.create();
	}
    
	/*privacy update*/
    public UserResponse privacyUpdate(String password, Integer skin, String smsagree, String emailagree, String token) {
    	
    	Call<UserResponse> call = this.privacyRetro.privacy(password, skin, smsagree, 
				emailagree, token, "application/x-www-form-urlencoded");
    	
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
    
    
    /*privacy sns connect*/
    public CommonResponse privacySnsCon(String sns_id, String sns_type, String token) {
    	
    	Call<CommonResponse> call = this.privacyRetro.privacySnsCon(sns_id, sns_type, 
    			token, "application/x-www-form-urlencoded");
    	
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
    
    
    /*privacy sns disConnect*/
    public CommonResponse privacySnsDisCon(String sns_type, String token) {
    	
    	Call<CommonResponse> call = this.privacyRetro.privacySnsDisCon(sns_type, 
    			token, "application/x-www-form-urlencoded");
    	
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
    
	
	protected PrivacyRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
        return retrofit.create(PrivacyRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}
