package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.BalgreConstants;
import net.balgre.domain.BestResponse;
import net.balgre.domain.PageReview;
import net.balgre.domain.ProductItem;
import net.balgre.domain.ProductResponse;
import net.balgre.domain.RelationResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.MainService;
import net.balgre.service.ProductService;
import net.balgre.service.ReviewService;
import net.balgre.service.WishService;


@Controller
public class ProductController {

    @Autowired
    private ProductService service;
    
    @Autowired
    private WishService wishService;
    
    @Autowired
    private MainService mainService;
    
    @Autowired
    private ReviewService reviewService;
    

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productGET () throws Exception {

        return "/product/product";

    }
    
    /* 찜 버튼(하트모양) 때문에 코드 추가함 // 2017-05-31 minho */
    @RequestMapping(value = "/bestProduct", method = RequestMethod.GET)
    public String bestProductGET (Model model, HttpSession session) throws Exception {

    	/* 추가부분 시작 */
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	/* 추가부분 종료 */

        model.addAttribute("showBestProduct", service.bestResponseGET());

        return "/product/bestProduct";

    }


    @RequestMapping(value = "/categoryProduct", method = RequestMethod.GET)
    public void categoryProductGET (Model model) throws Exception {

        /*model.addAttribute("showCategoryProduct", service.boxGET());*/

//        return "/product/categoryProduct";
    }
    

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailProductGET (@RequestParam("product_id") long product_id,
                                  Model model, HttpSession session,
                                  @RequestParam(required=false, defaultValue="1") String sort,
                                  @RequestParam(required=false, defaultValue="0") String isDev) throws Exception {
    	
    	
    	/* 추가부분 시작 */
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	/* 추가부분 종료 */
        ProductResponse res = service.productDetailGET(product_id);
        List<ProductItem> pi2 = res.getProductItem();
        ProductItem pi = pi2.get(0);
        
        int page = 0;
        int photo = 0;
        PageReview rev = reviewService.reviewList2(page, product_id, photo, Integer.parseInt(sort));
        
        RelationResponse res2 = service.relationProduct(product_id);
        
        
        model.addAttribute("choiceDetailProduct", res);
        model.addAttribute("pi", pi);
        model.addAttribute("showMain", mainService.showMain());
        model.addAttribute("cate", res2.getCategoryProduct());
        model.addAttribute("brand", res2.getBrandList());
        model.addAttribute("review", rev);
        model.addAttribute("isDev", isDev);
        model.addAttribute("np_order", BalgreConstants.NAVER_PAY_ORDER);
        return "/product/productDetail";

    }
    
    /*time sale list by minho*/
    @RequestMapping(value = "/bg/timeSale", method = RequestMethod.GET)
    public String timeSaleList(Model model, HttpSession session) {
    	
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	
    	model.addAttribute("Res", service.timeSaleList2());
    	
    	return "/timeSale/timeSale";
    }
    
    
    /*balgeure box by minho*/
    @RequestMapping(value = "/bg/box", method = RequestMethod.GET)
    public String balgeureBox(Model model, HttpSession session) {
    	
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	
    	model.addAttribute("Res", service.balgeureBox2());
    	
    	return "/product/balgeureBox";
    }
    
    
    /*new product by minho*/
    @RequestMapping(value = "/bg/new", method = RequestMethod.GET)
    public String newProduct(Model model, HttpSession session) {
    	
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    	}
    	
    	BestResponse res = service.newProduct2();
    	
    	model.addAttribute("best", res);
    	//model.addAttribute("Res", res.getProductList());
    	
    	return "/product/new";
    }

}