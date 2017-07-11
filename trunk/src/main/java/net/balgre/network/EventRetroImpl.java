package net.balgre.network;

import java.io.IOException;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import net.balgre.domain.AttendanceInfo;
import net.balgre.domain.AttendanceResponse;
import net.balgre.domain.Event;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventRetroImpl {

	private EventRetro eventRetro = null;

	public EventRetroImpl() {
		this.eventRetro = this.create();
	}

	public List<Event> eventList() {
		Call<List<Event>> call = this.eventRetro.eventList();

		try {
			Response<List<Event>> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Event eventDetail(Long eid) {

		Call<Event> call = this.eventRetro.eventDetail(eid);

		try {
			Response<Event> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 당월 출석체크
	public AttendanceResponse attendance(String token) {
		Call<AttendanceResponse> call = this.eventRetro.attendance(token, BalgreConstants.CONTENT_TYPE);

		try {
			Response<AttendanceResponse> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 출석체크 정보
	public AttendanceInfo attendanceInfo(String token) {
		Call<AttendanceInfo> call = this.eventRetro.attendanceInfo(token, BalgreConstants.CONTENT_TYPE);

		try {
			Response<AttendanceInfo> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 당월 출석체크
	public AttendanceResponse attendanceList(String token) {
		Call<AttendanceResponse> call = this.eventRetro.attendanceList(token, BalgreConstants.CONTENT_TYPE);

		try {
			Response<AttendanceResponse> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 스탬프 교환
	public AttendanceResponse stamp(String token, Long st_id) {
		Call<AttendanceResponse> call = this.eventRetro.stamp(token, BalgreConstants.CONTENT_TYPE, st_id);

		try {
			Response<AttendanceResponse> response = call.execute();
			if (response.isSuccessful()) {

				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	protected EventRetro create() {
		Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

		return retrofit.create(EventRetro.class);
	}

	protected GsonConverterFactory buildGsonConverter() {

		GsonBuilder gsonBuilder = new GsonBuilder();

		Gson myGson = gsonBuilder.create();

		return GsonConverterFactory.create(myGson);
	}
}
