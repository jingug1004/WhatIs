package net.balgre.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.MainResponse;
import net.balgre.domain.Product;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MainRetroImpl {

    private MainRetro mainRetro = null;

    public MainRetroImpl() {
        this.mainRetro = this.create();
    }

    public MainResponse getMain() {
        Call<MainResponse> call = this.mainRetro.getMain();
        try {
            Response<MainResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProduct(Long productId) {
        Call<Product> call = this.mainRetro.getProduct();
        try {
            Response<Product> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    protected MainRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(MainRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }

}
