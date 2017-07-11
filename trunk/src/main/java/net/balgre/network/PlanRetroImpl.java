package net.balgre.network;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class PlanRetroImpl {


    private PlanRetro planRetro = null;

    public PlanRetroImpl() {
        this.planRetro = this.create();
    }


    /*plan list by minho*/
    public PagePlan planList2(int page) {

        Call<PagePlan> call = this.planRetro.planList(page);

        try {
            Response<PagePlan> response = call.execute();
            if (response.isSuccessful()) {

                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*plan detail by minho*/
    public Plan planDetail2(long pid) {

        Call<Plan> call = this.planRetro.planDetail(pid);

        try {
            Response<Plan> response = call.execute();
            if (response.isSuccessful()) {

                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected PlanRetro create() {

    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(PlanRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}
