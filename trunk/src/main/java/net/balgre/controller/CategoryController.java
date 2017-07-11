package net.balgre.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.PageProduct;
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
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	/* 추가부분 종료 */
		int page = 0;
		
		PageProduct pp = productService.categoryList2(parent, page, menu_id, sort);
		
		model.addAttribute("categor", pp);
		model.addAttribute("menu_id", menu_id);
		
		return "/product/category";
	}

}
