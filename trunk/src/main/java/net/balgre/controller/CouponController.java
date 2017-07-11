package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.domain.CouponUser;
import net.balgre.domain.CouponUserResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.CouponService;

@Controller
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	
	/*coupon list*/
	@RequestMapping(value = "/my/coupon")
	public String myCouponList(Model model, HttpSession session, String token) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		CouponUserResponse res = couponService.myCouponList2(login.getToken());

		List<CouponUser> couponUser = res.getCouponUserList();
		
		model.addAttribute("CouponUser", couponUser);
		
		return "myPage/myCoupon/myCouponList";
	}
	
	
	/*coupon insert*/
	@RequestMapping(value = "/my/couponInsert", method = RequestMethod.POST)
	public String myCouponInsert(Model model, HttpSession session, String token, String c_id) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		CouponUserResponse res = couponService.myCouponInsert2(login.getToken(), c_id);
		
		return "myPage/myCoupon/myCouponList";
		
	}
	
}
