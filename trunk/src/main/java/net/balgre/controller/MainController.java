package net.balgre.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.AppBasketResponse;
import net.balgre.domain.CommonResponse;
import net.balgre.domain.Product;
import net.balgre.domain.ProductTimeSale;
import net.balgre.domain.WishListResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.BasketService;
import net.balgre.service.MainService;
import net.balgre.service.ProductService;
import net.balgre.service.WishService;


@Controller
public class MainController {

    @Autowired
    private MainService service;
    
    // 추가영역 시작
    @Autowired
    private ProductService productService;
    
    @Autowired
    private WishService wishService;
    
    @Autowired
	private BasketService basketService;
    // 추가영역 종료
    
    // 메인으로
    // 카테고리 때문에 코드 추가함 by minho
    @RequestMapping(value = {"/main", "/"}, method = RequestMethod.GET)
    public String mainGET(Model model, HttpSession session) throws Exception {
        
        // 추가영역 시작
        LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
        if (login != null) {
        	model.addAttribute("Wish", wishService.wishList2(login.getToken()));
        }
        
        List<ProductTimeSale> timeSale = productService.timeSaleList2();
        
        List<ProductTimeSale> randomList = new ArrayList<ProductTimeSale>();
        
        Calendar c1 = Calendar.getInstance();
        
        for (int i=0; i<timeSale.size(); i++) {
        	if (timeSale.get(i).getProduct().getStopSelling() == 0 && timeSale.get(i).getProduct().getTimeSale() == 0) {
        		long toDate = c1.getTimeInMillis();
        		long endDate = timeSale.get(i).getEndDate();
        		
        		if (timeSale.get(i).getTimeType() == 0 && endDate > toDate || timeSale.get(i).getTimeType() == 1 && timeSale.get(i).getRnCount() > 0) {
        		
        			randomList.add(timeSale.get(i));
        		
        		}
        	}
        }
        
        Collections.shuffle(randomList);
        
        model.addAttribute("Res", randomList.subList(0, 4));
        
        List<Product> bestProduct = productService.bestResponseGET().getProductList();
        
        model.addAttribute("best", bestProduct.subList(0, 8));
        // 추가영역 종료
        
        model.addAttribute("showMain", service.showMain());

		return "/main/main";

	}


	@RequestMapping(value="header_info", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getHeaderInfo(HttpSession session) throws Exception {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		AppBasketResponse basketList =  basketService.basketList(login.getToken());
		WishListResponse wishList = wishService.wishList2(login.getToken());
		Map<String, Object> headerInfo = new HashMap<>();
		headerInfo.put("basketList", basketList);
		headerInfo.put("wishlist", wishList);
		
		return headerInfo;

	}
	
	@RequestMapping("/sendSms")
	@ResponseBody
	public CommonResponse sendSms(@RequestParam("phone") String phone) throws Exception {
		return service.sendSms(phone);
	}
}
