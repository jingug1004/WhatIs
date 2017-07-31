package net.balgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	
	/*search*/
	@RequestMapping(value = "/product/search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam(value="search", required=false)String search) {
		
		model.addAttribute("Res", searchService.search2(search));
		model.addAttribute("search", search);
		
		return "/search/search";
	}

}
