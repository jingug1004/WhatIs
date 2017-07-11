package net.balgre.network;

import java.util.List;

import net.balgre.domain.HomeShopping;
import net.balgre.domain.HomeShoppingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BroadCastRetro {
	
	/*방송 편성표*/
	@GET("/api/hshopping/guide")
	Call<List<HomeShopping>> broadCastSchedule(
		@Query("date") String date
	);
	
	
	/*방송 있는 날*/
	@GET("/api/hshopping/guide_date")
	Call<List<Integer>> braodDate(
			
	);
	
	
	/*현재 방송 정보*/
	@GET("/api/hshopping/now")
	Call<HomeShoppingResponse> broadCastInformation(
		
	);

}
