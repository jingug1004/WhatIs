package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.MyReviewResponse;
import net.balgre.domain.PageReview;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReviewRetroImpl {

    private ReviewRetro reviewRetro = null;

    public ReviewRetroImpl() {
        this.reviewRetro = this.create();
    }

    public MyReviewResponse possibleReview(String token) {
    	
    	Call<MyReviewResponse> call = this.reviewRetro.PossibleReview(
    			token, "application/x-www-form-urlencoded");
    	
    	try {
    		Response<MyReviewResponse> response = call.execute();
    		if(response.isSuccessful()) {
    		    return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    public PageReview reviewList2(int page, long product_id, int photo, int sort) {
    	
    	Call<PageReview> call = this.reviewRetro.reviewList(page, product_id, photo, sort);
    	
    	try {
    		Response<PageReview> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }


    protected ReviewRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
        return retrofit.create(ReviewRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }

}