package net.balgre.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.PageUserPoint;
import net.balgre.domain.PointResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.PointService;

@Controller
public class PointController {
	
	@Autowired
	private PointService pointService;
	
	/*my point*/
	@RequestMapping(value = "/my/point")
	public String myPoint(Model model, HttpSession session, String token, @RequestParam(required=false) int page) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		PointResponse res = pointService.myPoint2(login.getToken(), page);
		
		PageUserPoint pages = res.getPointList();
		
		model.addAttribute("MyPoint", res);
		model.addAttribute("Pages", pages.getContent());
		
		return "myPage/myPoint/myPoint";
	}

}
