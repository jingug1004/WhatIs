package net.balgre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaqController {
	
	@RequestMapping(value = "/cs/faq")
	public String faqList() throws Exception {
		
		return "/faq/faq";
	}

}
