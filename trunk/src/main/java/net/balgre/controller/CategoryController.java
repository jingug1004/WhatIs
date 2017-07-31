package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.PageBrand;
import net.balgre.domain.PageProduct;
import net.balgre.domain.Product;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.ProductService;
import net.balgre.service.WishService;

@Controller
public class CategoryController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	WishService wishService;
	
	/*category list by minho*/
	@RequestMapping("/categoryDetail")
	public String subCategoryList(Model model, HttpSession session, @RequestParam(required=false)long parent, 
			long menu_id, @RequestParam(required=false)int sort) {
		
		/* 추가부분 시작 */
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		if (menu_id == 104) {
    			String menuCheck = "6";
    			model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    			model.addAttribute("menuCheck", menuCheck);
    		} else if (menu_id == 105) {
    			String menuCheck = "7";
    			model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    			model.addAttribute("menuCheck", menuCheck);
    		} else {
    			model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    		}
    	}
    	/* 추가부분 종료 */
		int page = 0;
		
		PageProduct pp = productService.categoryList2(parent, page, menu_id, sort);
		
		if (menu_id == 104) {
			String menuCheck = "6";
			model.addAttribute("categor", pp);
			model.addAttribute("menu_id", menu_id);
			model.addAttribute("menuCheck", menuCheck);
		} else if (menu_id == 105) {
			String menuCheck = "7";
			model.addAttribute("categor", pp);
			model.addAttribute("menu_id", menu_id);
			model.addAttribute("menuCheck", menuCheck);
		} else {
			model.addAttribute("categor", pp);
			model.addAttribute("menu_id", menu_id);
		}
		
		return "/product/category";
	}
	
	/*brand list by minho*/
	@RequestMapping("/brandList")
	public String brandList(Model model, HttpSession session, @RequestParam(value="brand_id", required=false)long brand_id) {
		
		int page = 0;
		int sort = 0;
		
		PageBrand res = productService.brandList2(page, brand_id, sort);
		if (res.getContent().size() != 0) {
			
			List<Product> res2 = res.getContent();
			String name = res2.get(0).getBrand().getBrandName();
			
			model.addAttribute("Brand", res);
			model.addAttribute("brand_id", brand_id);
			model.addAttribute("brandName", name);
			
			return "/product/brand";
			
		} else {
			
			return "/product/brand";
			
		}
	}

}
