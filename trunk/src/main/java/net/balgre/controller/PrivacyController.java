package net.balgre.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.Shipping;
import net.balgre.domain.ShippingResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.PrivacyService;
import net.balgre.service.ShippingService;
import net.balgre.service.UserInfoService;

@Controller
public class PrivacyController {
	
	@Autowired
	private PrivacyService privacyService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	
	@RequestMapping("/addressPop")
	public String addressPop(Model model, HttpSession session) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		UserResponse res = userInfoService.getUserInfo2(login.getToken());
		
		model.addAttribute("User", res);
		
		return "myPage/myPrivacy/addressPop";
	}
	
	@RequestMapping("/my/privacy")
	public String goPrivacy(Model model, HttpSession session, String token) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		UserResponse res = privacyService.privacy2(login.getToken());
		ShippingResponse res2 = shippingService.getShipping2(login.getToken());
		
		User user = res.getUser();
		Shipping shipping = res2.getShipping();
		
		model.addAttribute("User", user);
		model.addAttribute("Shipping", shipping);
		
		return "myPage/myPrivacy/myPrivacy";
	}
	
	
	@RequestMapping(value = "/my/privacy/addressOk", method = RequestMethod.POST)
	public String privacyAddressUpdate(Model model, @RequestParam(value="name", required=false)String name,
			@RequestParam(value="phone", required=false)String phone,
			@RequestParam(value="zipcode", required=false)String zipcode, 
			@RequestParam(value="address1", required=false)String address1, 
			@RequestParam(value="address2", required=false)String address2,
			HttpSession session, String token) {
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(zipcode);
		System.out.println(address1);
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		ShippingResponse res = shippingService.shippingUpdate2(name, phone, zipcode, address1, address2, login.getToken());
		
		Shipping sp = res.getShipping();
		
		model.addAttribute("namez", name);
		model.addAttribute("phonez", phone);
		model.addAttribute("zipcodez", zipcode);
		model.addAttribute("address1z", address1);
		model.addAttribute("address2z", address2);
		model.addAttribute("Sp", sp);
			
		return "myPage/myPrivacy/myPrivacy";
	}
	
	
	/*privacy update*/
	@RequestMapping(value = "/my/privacy/update", method = RequestMethod.POST)
	public String privacyUpdate(Model model, HttpSession session, String password, 
			Integer skin, String smsagree, String emailagree, String token) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		UserResponse res = privacyService.privacyUpdate2(password, skin, smsagree, emailagree, login.getToken());
		
		User user1 = res.getUser();
		
		model.addAttribute("User", user1);
		
		return "redirect:/my/privacy";
	}
	
	
	/*privacy sns disconnect*/
	@RequestMapping(value = "/my/privacy/snsDisCon", method = RequestMethod.POST)
	@ResponseBody
	public String snsDisCon(Model model, HttpSession session, String token, @RequestParam(value="sns_type", required=false)String sns_type) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		CommonResponse res = privacyService.privacySnsDisCon2(sns_type, login.getToken());
		
		return "success";
	}
	
	
	@RequestMapping(value = "/my/privacy/snsCon", method = RequestMethod.POST)
	@ResponseBody
	public String snsCon(Model model, HttpSession session, String token, 
			@RequestParam(value="sns_type", required=false)String sns_type,
			@RequestParam(value="sns_id", required=false)String sns_id) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		CommonResponse res = privacyService.privacySnsCon2(sns_id, sns_type, login.getToken());
		
		return "success";
	}
	
	@RequestMapping(value ="/my/privacy/callback")
	public String callback2() {
		
		return "myPage/myPrivacy/naverRedirect";
	}

}
