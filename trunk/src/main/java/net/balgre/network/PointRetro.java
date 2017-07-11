package net.balgre.network;

import net.balgre.domain.PointResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface PointRetro {

	/*my point*/
	@GET("/api/v1/mypage/mypoint/{page}")
	Call<PointResponse> myPoint (
		@Header("X-Authorization") String token,
		@Header("Content-Type") String contentType,
		@Path("page") int page
	);
}
