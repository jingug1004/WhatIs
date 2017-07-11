package net.balgre.network;

import java.io.IOException;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.HomeShopping;
import net.balgre.domain.HomeShoppingResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BroadCastRetroImpl {
	
	private BroadCastRetro broadCastRetro = null;
	
	public BroadCastRetroImpl() {
		this.broadCastRetro = this.create();
	}
	
	
	/*방송 편성표*/
	public List<HomeShopping> broadCastSchedule(String date) {
		
		Call<List<HomeShopping>> call = this.broadCastRetro.broadCastSchedule(date);
		
		try {
			Response<List<HomeShopping>> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*방송 있는 날*/
	public List<Integer> broadDate() {
		
		Call<List<Integer>> call = this.broadCastRetro.braodDate();
		
		try {
			Response<List<Integer>> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*현재 방송 정보*/
	public HomeShoppingResponse broadCastInformation() {
		
		Call<HomeShoppingResponse> call = this.broadCastRetro.broadCastInformation();
		
		try {
			Response<HomeShoppingResponse> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected BroadCastRetro create() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl(BalgreConstants.API_URL).addConverterFactory(buildGsonConverter()).build();

		return retrofit.create(BroadCastRetro.class);
	}

	protected GsonConverterFactory buildGsonConverter() {
		GsonBuilder gsonBuilder = new GsonBuilder();

		Gson myGson = gsonBuilder.create();

		return GsonConverterFactory.create(myGson);
	}

}
