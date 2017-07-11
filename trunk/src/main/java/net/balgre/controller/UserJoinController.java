package net.balgre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserData;
import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.LoginService;
import net.balgre.service.UserInfoService;
import net.balgre.service.UserJoinService;

@Controller
public class UserJoinController {

    @Autowired
    // 의존 주입 설정
    private UserJoinService userJoinService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private LoginService loginService;
    
    
    /*회원가입 1.방법*/
    @RequestMapping("/howToJoin")
    public String howToJoin() {
    	return "/userJoin/howToJoin";
    }
    
    /*회원가입 2-1. mail 가입 동의*/
    @RequestMapping("/mailJoinAgree")
    public String mailJoinAgree() {
    	return "/userJoin/agree/mailJoinAgree";
    }
    
    
    /*회원가입 2-2. sns 가입 동의*/
    @RequestMapping("/snsJoinAgree")
    public String snsJoinAgree(Model model, 
    		@RequestParam("Type")String Type,
    		@RequestParam("NickName")String NickName,
    		@RequestParam("Email")String Email,
    		@RequestParam("sns_id")String sns_id) {
    	
    	model.addAttribute("type", Type);
    	model.addAttribute("nickName", NickName);
    	model.addAttribute("email", Email);
    	model.addAttribute("sns_id", sns_id);
    	
    	return "/userJoin/agree/snsJoinAgree";
    }
    

    // regist move controller
    @RequestMapping(value = "/mailRegist", method = RequestMethod.GET)
    public String regist(@RequestParam("param1")String param1,
    		@RequestParam("param2")String param2, Model model) {
    	
    	System.out.println(param1);
    	System.out.println(param2);
    	
    	model.addAttribute("sms", param1);
    	model.addAttribute("email", param2);
    	
        return "/userJoin/mailJoinForm";
    }
    
    // sns join form
    @RequestMapping(value = "/snsJoinForm", method = RequestMethod.GET)
    public String regist2(@RequestParam("Type")String Type, 
    		@RequestParam("smsAgree")String smsAgree, 
    		@RequestParam("emailAgree")String emailAgree,
    		@RequestParam("nickName")String nickName,
    		@RequestParam("email")String email,
    		@RequestParam("sns_id")String sns_id,
    		Model model) {
    	
    	System.out.println(Type);
    	System.out.println(smsAgree);
    	System.out.println(emailAgree);
    	
    	model.addAttribute("type", Type);
    	model.addAttribute("smsAgree", smsAgree);
    	model.addAttribute("emailAgree", emailAgree);
    	model.addAttribute("nickName", nickName);
    	model.addAttribute("email", email);
    	model.addAttribute("sns_id", sns_id);
        return "/userJoin/snsJoinForm";
    }

    
    // regist form post controller
    @RequestMapping(value = "/form_auth", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse userJoin(Model model, User user,
    		HttpSession session, HttpServletRequest request) throws Exception {
    	
    	System.out.println(user);
    	
    	UserResponse userRes = userJoinService.userJoin1(user);
        // service의 userJoin1 메서드 호출하면서 파라미터 전달
        
        LoginDTO loginDto = new LoginDTO();
		loginDto.setUsername(user.getEmail());
		loginDto.setPassword(user.getPassword());
        LoginDTO02 loginDTO02 = loginService.login(loginDto);

        System.out.println(loginDTO02);
        if (loginDTO02 == null) {
            return null;
        }

        model.addAttribute("userVO", loginDTO02);
        
        request.getSession().setAttribute("user", userRes.getUser());
        request.getSession().setAttribute("login", loginDTO02);

        return userRes;
    }


    /*send sms*/
    @RequestMapping(value="phone_check_data", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse phone_check(@RequestParam(value="phone") String phone) throws Exception {


        return userJoinService.phone_check(phone);
    }

    /*sms cert*/
    @RequestMapping(value="phone_check_data2", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse phone_check2(@RequestParam(value="phone") String phone, @RequestParam(value="cert") String cert) throws Exception {


        return userJoinService.phone_check2(phone, cert);
    }

}
