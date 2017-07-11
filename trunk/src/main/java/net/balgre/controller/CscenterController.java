package net.balgre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CscenterController {
	
	@RequestMapping(value = "/cs/cscenter")
	public String faqList() throws Exception {
		
		return "/faq/cscenter";
	}

}
