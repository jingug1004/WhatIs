package net.balgre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.balgre.domain.BestResponse;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CategoryResponse2;
import net.balgre.domain.PageBrand;
import net.balgre.domain.PageProduct;
import net.balgre.domain.Product;
import net.balgre.domain.ProductResponse;
import net.balgre.domain.ProductTimeSale;
import net.balgre.domain.RelationResponse;
import net.balgre.network.ProductRetroImpl;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public BestResponse bestResponseGET() throws Exception {

        ProductRetroImpl client = new ProductRetroImpl();

        BestResponse bestResponse = client.bestResponseGET();

        return bestResponse;

    }

    @Override
    public CategoryResponse categoryResponseGET() throws Exception {

        ProductRetroImpl client = new ProductRetroImpl();

        CategoryResponse categoryResponse = client.categoryResponseGET();

        return categoryResponse;
    }

    @Override
    public ProductResponse productDetailGET(long product_id1) throws Exception {

        ProductRetroImpl client = new ProductRetroImpl();

        ProductResponse response = client.detailGET(product_id1);

        return response;
    }

    
    /*time sale list by minho*/
	@Override
	public List<ProductTimeSale> timeSaleList2() {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		List<ProductTimeSale> res = PRI.timeSaleList();
		
		return res;
	}

	
	/*balgeure box by minho*/
	@Override
	public List<Product> balgeureBox2() {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		List<Product> res = PRI.balgeureBox();
		
		return res;
	}

	
	/*new product by minho*/
	@Override
	public BestResponse newProduct2() {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		BestResponse res = PRI.newProduct();
		
		return res;
	}

	
	/*category by minho*/
	@Override
	public CategoryResponse categoryList2() {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		CategoryResponse res = PRI.categoryList();
		
		return res;
	}

	
	/*sub category by minho*/
	@Override
	public CategoryResponse subCategory2(long menu_id) {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		CategoryResponse res = PRI.subCategory(menu_id);
		
		return res;
	}

	
	/*category list by minho*/
	@Override
	public PageProduct categoryList2(long parent, int page, long menu_id, int sort) {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		PageProduct res = PRI.categoryList2(parent, page, menu_id, sort);
		
		return res;
	}

	@Override
	public RelationResponse relationProduct(long product_id) {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		RelationResponse res = PRI.relationProduct2(product_id);
		
		return res;
	}

	@Override
	public CategoryResponse2 categoryList22() throws Exception {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		CategoryResponse2 res = PRI.categoryList2();
		
		return res;
	}

	@Override
	public PageBrand brandList2(int page, long brand_id, int sort) {
		// TODO Auto-generated method stub
		
		ProductRetroImpl PRI = new ProductRetroImpl();
		
		PageBrand res = PRI.brandList(page, brand_id, sort);

		return res;
	}
	
}