package net.balgre.network;

import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface MemberLeaveRetro {
	
	/*member leave*/
	@PUT("/api/v1/mypage/memberLeave")
	Call<UserResponse> memberLeave (
		@Header("X-Authorization") String token,
		@Header("Content-Type") String contentType,
		@Query("reason") String reason
	);

}
