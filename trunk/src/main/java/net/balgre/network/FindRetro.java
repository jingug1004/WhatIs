package net.balgre.network;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FindRetro {
	
	/*find id*/
	@GET("/api/user/find_id")
	Call<UserResponse> findId(
	    @Query("name") String name,
	    @Query("phone") String phone
	);
	
	/*find password email*/
	@GET("/api/user/find_email_pw")
	Call<CommonResponse> findPwEmail(
		@Query("email") String email,
		@Query("name") String name
	);
	
	/*find password phone*/
	@GET("/api/user/find_pw")
	Call<CommonResponse> findPwPhone(
		@Query("email") String email,
		@Query("phone") String phone
	);

}
