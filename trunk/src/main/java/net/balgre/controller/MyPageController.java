package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.CouponUserResponse;
import net.balgre.domain.Order;
import net.balgre.domain.PaymentResponse;
import net.balgre.domain.Payments;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.CouponService;
import net.balgre.service.PaymentService;
import net.balgre.service.PointService;

@Controller
@RequestMapping("/my")
public class MyPageController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PointService pointService;
	
	@Autowired
	private CouponService couponService;
	
	
	/*go myPage by minho*/
	@RequestMapping("/index")
	public String myPage(Model model, HttpSession session, String token, String page) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
//		UserResponse res = userService.getUserInfo2(login.getToken());
		
//		User uid = res.getUser();
		
		if (StringUtils.isEmpty(page)) {
			page = String.valueOf(0);
		}
		
		CouponUserResponse cu = couponService.myCouponList2(login.getToken());
		int cu2 = cu.getCouponUserList().size();
		List<Payments> myOrder = paymentService.myOrder(login.getToken());
		model.addAttribute("order", myOrder);
//		model.addAttribute("user", uid);
		model.addAttribute("point", pointService.myPoint2(login.getToken(), Integer.parseInt(page)));
		model.addAttribute("Coupon", cu2);
		
		return "/myPage/myPage";
	}
	

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(HttpSession session, Model model) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		List<Payments> myOrder = paymentService.myOrder(login.getToken());
		model.addAttribute("order", myOrder);
		return "/myPage/payment/order";
	}
	
	
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public String orderDetail(HttpSession session, Model model, @RequestParam("payment_id") String payment_id) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		Order myOrder = paymentService.myOrderDetail(login.getToken(), payment_id);
		model.addAttribute("order", myOrder);
		model.addAttribute("paymentId", payment_id);
		return "/myPage/payment/order_detail";
	}
	
	
	@RequestMapping(value = "/order_cancel", method = RequestMethod.POST)
	@ResponseBody
	public PaymentResponse orderCancel(HttpSession session, Model model, @RequestParam("payment_id") String payment_id) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		System.out.println(payment_id);
		
		PaymentResponse res = paymentService.orderCancel(login.getToken(), payment_id);
		System.out.println("res : " + res);
		model.addAttribute("payment", res);
		
		return res;
	}
}
