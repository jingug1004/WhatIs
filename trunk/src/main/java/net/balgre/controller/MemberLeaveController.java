package net.balgre.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.MemberLeaveService;

@Controller
public class MemberLeaveController {
	
	@Autowired
	private MemberLeaveService memberLeaveService;
	
	
	/*member leave agree page*/
	@RequestMapping(value = "/member/leaveAgree")
	public String memberLeaveAgree() {
		
		return "myPage/memberLeave/memberLeaveAgree";
	}
	
	
	/*member leave*/
	@RequestMapping(value = "/member/leave", method = RequestMethod.POST)
	public String memberLeave(HttpSession session, String token,
			@RequestParam(value="reason")String reason) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		UserResponse res = memberLeaveService.memberLeave2(login.getToken(), reason);
		
        session.removeAttribute("login");
		session.invalidate();
		
		return "redirect:/main";
	}

}
