package net.balgre.network;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.BestResponse;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CategoryResponse2;
import net.balgre.domain.PageBrand;
import net.balgre.domain.PageProduct;
import net.balgre.domain.Product;
import net.balgre.domain.ProductResponse;
import net.balgre.domain.ProductTimeSale;
import net.balgre.domain.RelationResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProductRetroImpl {

    private ProductRetro productRetro = null;

    public ProductRetroImpl() {
        this.productRetro = this.create();
    }

    public BestResponse bestResponseGET() {
        Call<BestResponse> call = this.productRetro.bestResponseGET();
        try {
            Response<BestResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CategoryResponse categoryResponseGET() {
        Call<CategoryResponse> call = this.productRetro.categoryResponseGET();
        try {
            Response<CategoryResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public CategoryResponse2 categoryList2() {
    	Call<CategoryResponse2> call = this.productRetro.categoryList2();
    	try {
    		Response<CategoryResponse2> response = call.execute();
    		if (response.isSuccessful()) {
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    public ProductResponse detailGET(long product_id3) {
        Call<ProductResponse> call = this.productRetro.detailGET(product_id3);
        try {
            Response<ProductResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PageBrand brandList(int page, long brand_id, int sort) {
        Call<PageBrand> call = this.productRetro.brandList(page, brand_id, sort);
        try {
            Response<PageBrand> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        /*public HashMap<String, Object> listParentPageGET(long parent3, int page3, long menu_id3, int sort3) {
            Call<HashMap<String, Object>> call = this.productRetro.listParentPageGET(parent3, page3, menu_id3, sort3);
            try {
                Response<HashMap<String, Object>> response = call.execute();
                if (response.isSuccessful()) {
                    System.out.println(response.body().get("content"));
                    System.out.println(response.body().toString());
                    return response.body();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }*/

        public List<Product> searchGET(String search3) {
            Call<List<Product>> call = this.productRetro.searchGET(search3);
            try {
                Response<List<Product>> response = call.execute();
                if (response.isSuccessful()) {
                    return response.body();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    
    /*time sale list by minho*/
    public List<ProductTimeSale> timeSaleList() {
            
    	Call<List<ProductTimeSale>> call = this.productRetro.timeSaleList();
            
    	try {
            Response<List<ProductTimeSale>> response = call.execute();
            if (response.isSuccessful()) {
                    
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /*balgeure box by minho*/
    public List<Product> balgeureBox() {
    	
    	Call<List<Product>> call = this.productRetro.balgeureBox();
    	
    	try {
    		Response<List<Product>> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    /*new product by minho*/
    public BestResponse newProduct() {
    	
    	Call<BestResponse> call = this.productRetro.newProduct();
    	
    	try {
    		Response<BestResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    /*category by minho*/
    public CategoryResponse categoryList() {
    	
    	Call<CategoryResponse> call = this.productRetro.categoryList();
    	
    	try {
    		Response<CategoryResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    /*category2 by minho*/
    public CategoryResponse subCategory(long menu_id) {
    	
    	Call<CategoryResponse> call = this.productRetro.subCategory(menu_id);
    	
    	try {
    		Response<CategoryResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    /*category list by minho*/
    public PageProduct categoryList2(long parent, int page, long menu_id, int sort) {
    	
    	Call<PageProduct> call = this.productRetro.categoryList(parent, page, menu_id, sort);
    	
    	try {
    		Response<PageProduct> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    public RelationResponse relationProduct2(long product_id) {
    	
    	Call<RelationResponse> call = this.productRetro.relationProduct(product_id);
    	
    	try {
    		Response<RelationResponse> response = call.execute();
    		if (response.isSuccessful()) {
    			
    			return response.body();
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

//    public ProductRetro getProduct(Long productId) {
//        Call<Product> call = this.productRetro.getProduct();
//        try {
//            Response<Product> response = call.execute();
//            if (response.isSuccessful()) {
//                System.out.println(response.body());
//                return response.body();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    protected ProductRetro create() {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        
//        new Retrofit.Builder()
//                .baseUrl(BalgreConstants.API_URL)
//                .addConverterFactory(buildGsonConverter())
//                .build();

        return retrofit.create(ProductRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);

    }

}
