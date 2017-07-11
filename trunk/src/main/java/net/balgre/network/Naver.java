package net.balgre.network;


import net.balgre.domain.NaverAccessToken;
import net.balgre.domain.NaverUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Naver {
	@POST("/oauth2.0/token")
	Call<NaverAccessToken> token(
		@Query("client_id") String client_id,
		@Query("client_secret") String client_secret,
		@Query("grant_type") String grant_type,
		@Query("state") String state,
		@Query("code") String code);
	
	@GET("https://openapi.naver.com/v1/nid/me")
	Call<NaverUserResponse> userData(
			@Header("Authorization") String auth
			);
}
