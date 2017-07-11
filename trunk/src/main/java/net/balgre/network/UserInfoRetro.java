package net.balgre.network;

import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserInfoRetro {
	
	
	/*user info by minho*/
	@POST("/api/v1/mypage/user_info")
	Call<UserResponse> getUserInfo(
	    @Header("X-Authorization") String token,
	    @Header("Content-Type") String contentType
	);

}
