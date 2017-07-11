package net.balgre.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.domain.MyReviewResponse;
import net.balgre.domain.Review;
import net.balgre.domain.ReviewWait;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.ReviewService;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
    
    @RequestMapping(value = "/myReview", method = RequestMethod.GET)
    public String myReview(HttpSession session, Model model) {
    	
    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
    	MyReviewResponse res = reviewService.possibleReview2(login.getToken());
    	List<ReviewWait> res2 = res.getReviewList();
    	List<Review> res3 = res.getMyReviewList();
    	model.addAttribute("res", res);
    	model.addAttribute("res2", res2);
    	model.addAttribute("res3", res3);
    	
    	return "/review/review";
    }
    

}