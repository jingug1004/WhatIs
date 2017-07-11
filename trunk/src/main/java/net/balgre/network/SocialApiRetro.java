package net.balgre.network;

import net.balgre.domain.NaverUserResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SocialApiRetro {
	
	/*naver*/
	@POST("v1/nid/me")
	Call<NaverUserResponse> naverUser(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);

}
