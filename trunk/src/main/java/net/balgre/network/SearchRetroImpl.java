package net.balgre.network;

import java.io.IOException;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.Product;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchRetroImpl {
	
	private SearchRetro searchRetro = null;
	
	public SearchRetroImpl() {
		this.searchRetro = this.create();
	}
	
	
	/*search*/
	public List<Product> search(String search) {
		
		Call<List<Product>> call = this.searchRetro.search(search);
		
		try {
			Response<List<Product>> response = call.execute();
			if (response.isSuccessful()) {
				
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected SearchRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(SearchRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }

}
