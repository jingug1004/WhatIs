package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.PlanService;
import net.balgre.service.WishService;


@Controller
public class PlanController {

    private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    private PlanService planService;
    
    @Autowired
    private WishService wishService;
    
    
    /*plan main by minho*/
    @RequestMapping(value = "/plan", method = RequestMethod.GET)
    public String planMain(Model model, @RequestParam(required=false) String pid) {
    	
    	String menuCheck = "3";
    	
    	List<Plan> pp = planService.planList2();
    	if (StringUtils.isEmpty(pid)) {
    		// null check class StringUtils.isEmpty
    		pid = String.valueOf(pp.get(0).getPid());
    		// parameter가 null이면 (...)을 pid에 대입
    	}
    	model.addAttribute("Plan", pp);
    	model.addAttribute("Plan2", planService.planDetail2(Long.parseLong(pid)));
    	model.addAttribute("menuCheck", menuCheck);
    	
    	return "/product/plan";
    }
    
 
    /*plan detail by minho*/
    @RequestMapping(value = "/plan/detail", method = RequestMethod.GET)
    public String planDetail(Model model, HttpSession session, @RequestParam(required=false) String pid) {
    	                                  // 필수값 pid
    	
    	String menuCheck = "3";
    	
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	if (login != null) {
    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
    		model.addAttribute("menuCheck", menuCheck);
    	}
    	
    	List<Plan> pp = planService.planList2();
    	if (StringUtils.isEmpty(pid)) {
    		// null check class StringUtils.isEmpty
    		pid = String.valueOf(pp.get(0).getPid());
    		// parameter가 null이면 (...)을 pid에 대입
    	}
    	model.addAttribute("pid", pid);
    	model.addAttribute("Plan", pp);
    	model.addAttribute("Plan2", planService.planDetail2(Long.parseLong(pid)));
    	model.addAttribute("menuCheck", menuCheck);

    	return "/product/planDetail";
    }

}