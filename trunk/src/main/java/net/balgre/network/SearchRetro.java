package net.balgre.network;

import java.util.List;

import net.balgre.domain.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRetro {
	
	@GET("/api/product/search")
	Call<List<Product>> search(
	    @Query("search") String search
	);

}
