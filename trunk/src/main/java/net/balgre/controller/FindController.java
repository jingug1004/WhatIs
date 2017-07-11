package net.balgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;
import net.balgre.service.FindService;

@Controller
public class FindController {
	
	@Autowired
	private FindService findService;
	
	
	@RequestMapping(value = "/goFindPw")
	public String goFindPw() {
		
		return "auth/08_2_popup";
	}
	
	@RequestMapping(value = "/goFindId")
	public String goFindId() {
		
		return "find/findId";
	}
	
	
	/*find id*/
	@RequestMapping(value = "/privacy/findId", method = RequestMethod.POST)
	@ResponseBody
	public String findId(@RequestParam(value="name", required=false)String name, 
			@RequestParam(value="phone", required=false)String phone) {
		
		UserResponse res = findService.findId2(name, phone);
		if(res == null) {
			return null;
		}
		User user = res.getUser();
		
		return user.getEmail();
	}
	
	
	/*find password email*/
	@RequestMapping(value = "/privacy/findPw", method = RequestMethod.POST)
	public String findPwEmail(@RequestParam(value="email")String email,
			@RequestParam(value="name")String name) {
		
		CommonResponse res = findService.findPwEmail2(email, name);
		
		return "find/findPwSuccess";
	}
	
	
	/*find password phone*/
	@RequestMapping(value = "/privacy/findPw2", method = RequestMethod.POST)
	public String findPwPhone(@RequestParam(value="email")String email,
			@RequestParam(value="phone")String phone) {
		
		CommonResponse res = findService.findPwPhone2(email, phone);
		
		return "find/findPwSuccess2";
	}

}
