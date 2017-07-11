package net.balgre.network;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PrivacyRetro {
	
	/*privacy update*/
	@POST("/api/v1/mypage/join_v2")
	Call<UserResponse> privacy(
	    @Query("password") String password,
	    @Query("skin") Integer skin,
	    @Query("smsagree") String smsagree,
	    @Query("emailagree") String emailagree,
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);
	
	/*privacy sns connect*/
	@POST("/api/v1/mypage/sns_conn")
	Call<CommonResponse> privacySnsCon(
        @Query("sns_id") String sns_id,
        @Query("sns_type") String sns_type,
        @Header("X-Authorization") String token,
        @Header("Content-Type") String contentType
	);
	
	/*privacy sns disConnect*/
	@POST("/api/v1/mypage/sns_dis")
	Call<CommonResponse> privacySnsDisCon(
	    @Query("sns_type") String sns_type,
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);
}
