package net.balgre.aop;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.balgre.domain.Brand;
import net.balgre.domain.CategoryLvResult;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CategoryResponse2;
import net.balgre.service.ProductService;

@Aspect
@Component
public class CategoryAspect {

    @Autowired
    private ProductService productService;

	
	@After("execution(* net.balgre.controller.*.*(..))")
	public void getCategory() throws Exception {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		List<CategoryLvResult> CL = (List<CategoryLvResult>) request.getSession().getAttribute("categoryList");
		
		if(CL == null) {
			
			CategoryResponse res = productService.categoryList2();
			CategoryResponse2 res2 = productService.categoryList22();
			
	        try {
	        	
	        	CL = res2.getCategoryList();
		        Map<String, Brand> BL = (Map<String, Brand>) res2.getBrandList();
		        request.getSession().setAttribute("categoryList", CL);
		        request.getSession().setAttribute("brandList", BL);
		        request.getSession().setAttribute("categoryList2", res2);
		        
	        } catch (Exception e) {
	        	
	        	e.printStackTrace();
	        	
	        }
	        
		}
	}
	
}
