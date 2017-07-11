
package net.balgre.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.balgre.service.LoginService;
import net.balgre.service.ProductService;


@Component
public class AuthInter extends HandlerInterceptorAdapter {

    @Inject
    private LoginService service;

    @Inject
    private ProductService productService;
    
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (session.getAttribute("login") == null) {

            saveDest(request);

            response.sendRedirect("/login");
            return false;
        }
        return true;


    }

    public void saveDest(HttpServletRequest req) {

        String uri = req.getRequestURI();

        String query = req.getQueryString();

        if (query == null || query.equals("null")) {
            query = "";
        } else {
            query = "?" + query;
        }

        if (req.getMethod().equals("GET")) {

            req.getSession().setAttribute("dest", uri + query);

        }
    }
}