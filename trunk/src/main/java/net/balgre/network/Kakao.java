package net.balgre.network;


import net.balgre.domain.AccessToken;
import net.balgre.domain.UserData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Kakao {
//	@SerializedName("grant_type")
//	private String grant_type;
//	
//	@SerializedName("client_id")
//	private String client_id;
//	
//	@SerializedName("redirect_uri")
//	private String redirect_uri;
//	
//	@SerializedName("code")
//	private String code;
	//headers.append('Content-Type', 'application/x-www-form-urlencoded');
	@POST("/oauth/token")
	Call<AccessToken> token(
		@Header("Content-Type") String type,
		@Query("grant_type") String grant_type,
		@Query("client_id") String client_id,
		@Query("redirect_uri") String redirect_uri,
		@Query("code") String code);
	
	@GET("https://kapi.kakao.com/v1/user/me")
	Call<UserData> userData(
			@Header("Authorization") String auth,
			@Header("Content-Type") String type
			);
}
