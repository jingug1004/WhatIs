package net.balgre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.service.MainService;

@Controller
public class TestController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {


        return "/myPage/test/";

    }

//    @RequestMapping(value = "/api/product/detail", method = RequestMethod.GET)
//    public void mainGET(Model model, Long a) throws Exception {
//
////        model.addAttribute("pId", mainService.id());
//
//    }

}
