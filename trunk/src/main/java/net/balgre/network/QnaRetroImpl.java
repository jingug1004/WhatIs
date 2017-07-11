package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.Qna;
import net.balgre.domain.QnaListResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QnaRetroImpl {
	
	// 5. QnaRetro 인터페이스 객체화
	private QnaRetro qnaRetro = null;
	
	// 3. Constructor 생성자 호출됨.(serviceImpl)
	public QnaRetroImpl() {
		this.qnaRetro = this.create();
	}
	
	// serviceImpl Call
	public CommonResponse qnaInsert2(String token, Qna qna) {
		qna.setQnaClass2("2");
		
		// 6. QnaRetro 객체의 qnaInsert 메서드 호출하면서 파라미터값 전달
		Call<CommonResponse> call = this.qnaRetro.qnaInsert(qna.getSubject(), qna.getQnaClass1(),
				qna.getQnaClass2(), qna.getContent(), null, qna.getOrderId(), token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<CommonResponse> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*qna list*/
	public QnaListResponse qnaList2(String token) {
		
		Call<QnaListResponse> call = this.qnaRetro.qnaList(token, 
				"application/x-www-form-urlencoded");
		
		try {
			Response<QnaListResponse> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*qna delete*/
	public QnaListResponse qnaDelete2(String token, int id) {
		
		Call<QnaListResponse> call = this.qnaRetro.qnaDelete(token, 
				"application/x-www-form-urlencoded", id);
		
		try {
			Response<QnaListResponse> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*qna detail*/
	/*public Qna qnaDetail2(String token) {
		
		Call<Qna> call = this.qnaRetro.qnaDetail(token, 
				"application/x-www.form-urlencoded");
		
		try {
			Response<Qna> response = call.execute();
			if (response.isSuccessful()) {
				System.out.println(response.body());
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
    protected QnaRetro create() {
    	
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();
        return retrofit.create(QnaRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}
