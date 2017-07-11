package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.PointResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PointRetroImpl {

	private PointRetro pointRetro = null;

	public PointRetroImpl() {
		this.pointRetro = this.create();
	}

	/* my point */
	public PointResponse myPoint2(String token, int page) {

		Call<PointResponse> call = this.pointRetro.myPoint(token, 
				"application/x-www-form-urlencoded", page);

		try {
			Response<PointResponse> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected PointRetro create() {

		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

		return retrofit.create(PointRetro.class);
	}

	protected GsonConverterFactory buildGsonConverter() {
		GsonBuilder gsonBuilder = new GsonBuilder();

		Gson myGson = gsonBuilder.create();

		return GsonConverterFactory.create(myGson);
	}

}
