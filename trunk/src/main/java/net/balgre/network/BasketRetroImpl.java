
package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.AppBasketResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BasketRetroImpl {

    private BasketRetro basketRetro = null;

    public BasketRetroImpl() {
        this.basketRetro = this.create();
    }

    public AppBasketResponse basketList(String token) {

        Call<AppBasketResponse> call = this.basketRetro.basket
                (token, "application/x-www-form-urlencoded");

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppBasketResponse basketAdd(String token, Long itemId, Long itemCount) {

        Call<AppBasketResponse> call = this.basketRetro.basketAdd
                (token, "application/x-www-form-urlencoded", itemId, itemCount);

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppBasketResponse basketDelete(String token, Long basket_id[]) {

        Call<AppBasketResponse> call = this.basketRetro.basketDelete
                (token, "application/x-www-form-urlencoded", basket_id);

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppBasketResponse basketUpdate(String token, Long basket_id, int item_count) {

        Call<AppBasketResponse> call = this.basketRetro.basketUpdate
                (token, "application/x-www-form-urlencoded", basket_id, item_count);

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppBasketResponse basketUpdateCheck(String token, Long basket_id[], int checked) {

        Call<AppBasketResponse> call = this.basketRetro.basketUpdateCheck
                (token, "application/x-www-form-urlencoded", basket_id, checked);

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public AppBasketResponse basketUpdateCheckAll(String token, int checked) {

        Call<AppBasketResponse> call = this.basketRetro.basketUpdateCheckAll
                (token, "application/x-www-form-urlencoded", checked);

        try {
            Response<AppBasketResponse> response = call.execute();

            if (response.isSuccessful()) {

                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    protected BasketRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(BasketRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}