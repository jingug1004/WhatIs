package net.balgre.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.Qna;
import net.balgre.domain.QnaListResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.QnaService;


@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	/*qna move controller*/
	@RequestMapping("/goQna")
	public String goQna() throws Exception {
		
		return "qna/qnaForm";
	}
	
	
	/*@RequestMapping("/goQnaList")
	public String goQnaList() throws Exception {
		
		return "qna/qnaListForm";
	}*/
	
	
	/*qna post controller*/
	@RequestMapping(value = "/input_form", method = RequestMethod.POST)
	public String qnaInsert(Model model, HttpSession session, Qna qna, String token) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		CommonResponse res = qnaService.qnaInsert1(qna, login.getToken());
		
		return "redirect:/my/qnaList";
	}
	
	
	@RequestMapping("/my/qna")
	public String goQnaForm(Model model, HttpSession session, String token) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		UserResponse res = qnaService.getUserInfo(login.getToken());
		
		User user = res.getUser();
		
		model.addAttribute("User", user);
				
		return "myPage/qna/qnaForm2";
	}
	
	
	@RequestMapping("/detail")
	public String detailAjax() {
		return "myPage/qna/qnaReplyForm";
	}
	
	
	@RequestMapping("/my/qnaDetail2")
	public String qnaDetail2(Model model, HttpSession session, String token, @RequestParam(value="qna", required=false) String qna) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		model.addAttribute("qna", qna);
		
		return "myPage/qna/qnaReplyForm";
	}
	
	
	/*qna list response controller*/
	@RequestMapping("/my/qnaList")
	public String qnaListResponse(Model model, HttpSession session, String token) throws Exception {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		QnaListResponse res = qnaService.qnaListResponse(login.getToken());
		
		List<Qna> qnaList = res.getQnaList();
		Qna qna = new Qna();
		
        for(int i=0; i<qnaList.size(); i++) {
			
			qna = res.getQnaList().get(i);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	        Date date = new Date(Long.parseLong(qna.getRegDate()));
	         
	        String regDate = sdf.format(date);
	        
	        qna.setRegDate(regDate);
			model.addAttribute("qnaList", qnaList);
				
		}


        model.addAttribute("qnaList", qnaList);
        
        
        return "myPage/qna/qnaListForm";

    }
	
	
	/*qna delete*/
	@RequestMapping(value = "/qna/delete", method = RequestMethod.POST)
	public String qnaDelete(Model model, HttpSession session, String token, int id) {
		
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		
		QnaListResponse res = qnaService.qnaDelete(login.getToken(), id);
		
		return "redirect:/my/qnaList";
	}
	

}
