package net.balgre.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.balgre.dto.LoginDTO02;


@Component
public class LoginInter extends HandlerInterceptorAdapter {

    public static final String LOGIN = "login";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (session.getAttribute(LOGIN) != null) {
            session.removeAttribute(LOGIN);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();

        /*
        ModelMap modelMap = modelAndView.getModelMap();
        Object userVO = modelMap.get("userVO");

        if (userVO != null) {

            session.setAttribute(LOGIN, userVO);

            */

       
        if(modelAndView != null) {
        	 ModelMap modelMap = modelAndView.getModelMap();
        LoginDTO02 userVO = (LoginDTO02)modelMap.get("userVO");

        if (userVO != null) {

            session.setAttribute(LOGIN, userVO);
        

//            Object dest = session.getAttribute("dest");
//
//            response.sendRedirect(dest != null ? (String) dest : "/");

        }
        }
    }
}