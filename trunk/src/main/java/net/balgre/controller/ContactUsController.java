package net.balgre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {
	
	@RequestMapping("/contactUs")
	public String contactUs() {
		
		return "/contactUs/contactUs";
	}

}
