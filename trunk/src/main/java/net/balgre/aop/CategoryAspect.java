package net.balgre.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.balgre.domain.Brand;
import net.balgre.domain.CategoryLvResult;
import net.balgre.domain.CategoryResponse;
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
	        
	        CL = res.getCategoryList();
	        List<Brand> BL = res.getBrandList();
	        request.getSession().setAttribute("categoryList", CL);
	        request.getSession().setAttribute("brandList", BL);
		}
	}
}
