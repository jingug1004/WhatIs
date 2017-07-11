package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.Notice;
import net.balgre.domain.NoticeResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticeRetroImpl {
	
	private NoticeRetro noticeRetro = null;
	
	public NoticeRetroImpl() {
		this.noticeRetro = this.create();
	}
	
	/*notice list*/
	public NoticeResponse noticeList2(int page) {
		
		Call<NoticeResponse> call = this.noticeRetro.noticeList(page);
		
		try {
			Response<NoticeResponse> response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("server->retroimpl : " + response.body());
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*notice detail*/
	public Notice noticeDetail2(long notice_id) {
		
		Call<Notice> call = this.noticeRetro.noticeDetail(notice_id);
		
		try {
			Response<Notice> response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("server->retroimpl : " + response.body());
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected NoticeRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(NoticeRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }

}
