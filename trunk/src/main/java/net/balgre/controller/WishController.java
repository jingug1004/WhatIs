package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.WishListResponse;
import net.balgre.domain.Wishlist;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.WishService;

@Controller
public class WishController {
	
	@Autowired
	private WishService wishService;
	
	
	/*wish add*/
	@RequestMapping(value = "/wish/add", method = RequestMethod.POST)
	@ResponseBody
	public WishListResponse wishAdd(HttpSession session, @RequestParam("product_id") long product_id) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		if (login == null) {
			
			return null;
		} else {
			WishListResponse res = wishService.wishAdd2(login.getToken(), product_id);
			
			return res;
		}
	}
	
	
	/*wish list*/
	@RequestMapping(value = "/my/wishList")
	public String wishList(Model model, HttpSession session, String page) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		WishListResponse res = wishService.wishList2(login.getToken());
		
		int start = (Integer.parseInt(page)*10) - 10;
		int end = (Integer.parseInt(page)*10);
		
		int totalCount = res.getWishList().size();
		
		List<Wishlist> wishList = res.getWishList();
		
		if (end > totalCount) {
			List<Wishlist> wishList2 = wishList.subList(start, totalCount);
			
			model.addAttribute("WishList", wishList2);
			model.addAttribute("totalCnt", totalCount);
		} else {
			List<Wishlist> wishList2 = wishList.subList(start, end);
			
			model.addAttribute("WishList", wishList2);
			model.addAttribute("totalCnt", totalCount);
		}
		
		return "wish/wishList";
	}


	/*wish delete*/
	@RequestMapping(value = "/my/wishDelete", method = RequestMethod.POST)
	public String wishDelete(Model model, HttpSession session, long wish_id) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		WishListResponse res = wishService.wishDelete2(login.getToken(), wish_id);
		
		return "redirect:/my/wishList?page=1";
	}

}
