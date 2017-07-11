package net.balgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.service.EmailService;

@Controller
public class MailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/mail/sender", method = RequestMethod.POST)
	@ResponseBody
	public String mailSender(String to, @RequestParam(value="mail")String mail, 
			@RequestParam(value="subject")String subject, 
			@RequestParam(value="cName")String cName,
			@RequestParam(value="mName")String mName, 
			@RequestParam(value="cNumber")String cNumber,
			@RequestParam(value="cCEOName")String cCEOName,
			@RequestParam(value="phone")String phone, 
			@RequestParam(value="content")String content) {
		
		to = "sumcreative@naver.com";
		
		emailService.sendSimpleMessage(to, mail, subject, cName, mName, cNumber, cCEOName, phone, content);
		
		return "success";
	}

}
