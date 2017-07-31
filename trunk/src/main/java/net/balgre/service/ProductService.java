package net.balgre.service;

import java.util.List;

import net.balgre.domain.BestResponse;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CategoryResponse2;
import net.balgre.domain.PageBrand;
import net.balgre.domain.PageProduct;
import net.balgre.domain.Product;
import net.balgre.domain.ProductResponse;
import net.balgre.domain.ProductTimeSale;
import net.balgre.domain.RelationResponse;



public interface ProductService {

    public BestResponse bestResponseGET() throws Exception;

    public CategoryResponse categoryResponseGET() throws Exception;

    public ProductResponse productDetailGET(long product_id1) throws Exception;
    
    public CategoryResponse2 categoryList22() throws Exception;
    
    /*time sale list by minho*/
    public List<ProductTimeSale> timeSaleList2();
    
    /*balgeure box by minho*/
    public List<Product> balgeureBox2();
    
    /*new product by minho*/
    public BestResponse newProduct2();
    
    /*category by minho*/
    public CategoryResponse categoryList2();
    
    /*sub category by minho*/
    public CategoryResponse subCategory2(long menu_id);
    
    /*category list by minho*/
    public PageProduct categoryList2(long parent, int page, long menu_id, int sort);
    
    /*relation response by minho*/
    public RelationResponse relationProduct(long product_id);
    
    /*brand list by minho*/
    public PageBrand brandList2(int page, long brand_id, int sort);

}
