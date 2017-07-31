package net.balgre.network;

import java.util.List;

import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface PlanRetro {

    /*plan list by minho*/
    @GET("/api/plan/web")
    Call<List<Plan>> planList (
    );

    /*plan detail by minho*/
    @GET("/api/plan")
    Call<Plan> planDetail (
            @Query("pid") long pid
    );
}