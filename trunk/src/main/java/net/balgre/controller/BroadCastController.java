package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.domain.BestResponse;
import net.balgre.domain.HomeShopping;
import net.balgre.domain.HomeShoppingResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.BroadCastService;
import net.balgre.service.ProductService;
import net.balgre.service.WishService;

@Controller
public class BroadCastController {

	@Autowired
	private BroadCastService broadCastService;
	
	@Autowired
	private WishService wishService;
	
	@Autowired
	private ProductService productService;
	
	
	/*@RequestMapping(value = "/broadCast", method = RequestMethod.GET)
	public String broadCastSchedule(Model model, 
			@RequestParam(required=false) String date) {
		
		List<HomeShopping> res = broadCastService.broadCastSchedule2(date);
		List<Integer> res2 = broadCastService.broadDate();
		
		model.addAttribute("Res2", res2);
		model.addAttribute("Res", res);
		
		return "broadCast/broadCast";
	}*/
	
	
	@RequestMapping(value = "/broadCast", method = RequestMethod.GET)
	public String broadCastInformation(Model model, HttpSession session) throws Exception {
		
		String menuCheck = "5";
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    		model.addAttribute("menuCheck", menuCheck);
    	}
    	
		HomeShoppingResponse res = broadCastService.broadCastInformation2();
		List<HomeShopping> res2 = res.getNextHShop();
		model.addAttribute("info", res);
		model.addAttribute("best", productService.bestResponseGET());
		model.addAttribute("menuCheck", menuCheck);
		
		String deviceType = (String) session.getAttribute("deviceType");
        if(deviceType.equals("mobile")) {
        	return "/broadCast/m_broadCast";
        }
        return "/broadCast/broadCast";
	}
	
}
