package net.balgre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.LoginService;
import net.balgre.service.UserInfoService;


@Controller
public class LoginController {

    @Autowired
    private LoginService service;


    @Autowired
    private UserInfoService userInfoService;
    
    // 로그인 접속
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET() throws Exception {

        return "/auth/loginPop";

    }
    
    @RequestMapping(value = "/loginPop", method = RequestMethod.GET)
    public String loginPop() throws Exception {
        return "/auth/loginPop";

    }
    
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public String loginPOST(LoginDTO dto,
                          HttpSession session,
                          Model model) throws Exception {

        LoginDTO02 loginDTO02 = service.login(dto);


        if (loginDTO02 == null) {

            return "/auth/login";
        }

        model.addAttribute("userVO", loginDTO02);

        UserResponse userRes = userInfoService.getUserInfo2(loginDTO02.getToken());
        session.setAttribute("user", userRes.getUser());
        
        // 기존 main/main 으로 리턴을 줄 시 url이 loginPost가 되어서
        // main 페이지에 기본적으로 뿌려주는 카테고리가 깨지게 되므로 redirect로 변경함. by minho(2017-05-25)
        return "redirect:/main";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpSession session) throws Exception {

        Object obj = session.getAttribute("login");

        if (obj != null) {

            LoginDTO02 vo = (LoginDTO02) obj;

            session.removeAttribute("login");
            session.invalidate();

//            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

//            if (loginCookie != null) {
//
//                loginCookie.setPath("/");
//                loginCookie.setMaxAge(0);
//                response.addCookie(loginCookie);
//                service.keepLogin(vo.getUid(), session.getId(), new Date());
//            }
        }

        return "redirect:/main";

    }

}