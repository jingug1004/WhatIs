package net.balgre.network;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.Qna;
import net.balgre.domain.QnaListResponse;
import net.balgre.domain.QnaPhoto;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;

import java.util.List;

public interface QnaRetro {
	
	@PUT("/api/v1/mypage/qna")
	Call<CommonResponse> qnaInsert(
	    @Query("subject") String subject,
	    @Query("qnaClass1") String qnaClass1,
	    @Query("qnaClass2") String qnaClass2,
	    @Query("content") String content,
	    @Query("files") List<QnaPhoto> files,
	    @Query("orderId") long orderId,
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);
	
	
	@GET("/api/v1/mypage/qna/list")
	Call<QnaListResponse> qnaList(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
    );
	
	@GET("/api/v1/mypage/qna/list")
	Call<Qna> qnaDetail(
		@Header("X-Authorization") String token,
		@Header("Content-Type") String contentType
	);
	
	@DELETE("/api/v1/mypage/qna/delete")
	Call<QnaListResponse> qnaDelete(
		@Header("X-Authorization") String token,
		@Header("Content-Type") String contentType,
		@Query("qnaId") long qnaId
	);
	
}
