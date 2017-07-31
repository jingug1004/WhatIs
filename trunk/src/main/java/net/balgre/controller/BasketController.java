
package net.balgre.controller;

import net.balgre.BalgreConstants;
import net.balgre.domain.AppBasketResponse;
import net.balgre.domain.BasketResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @RequestMapping(value = "/basketList", method = RequestMethod.GET)
    public String basketListGET(HttpSession session, Model model,
            @RequestParam(required=false, defaultValue="0") String isDev) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        basketService.basketUpdateCheckAll(login.getToken(), 1);
        model.addAttribute("basketList", basketService.basketList(login.getToken()));
        model.addAttribute("isDev", isDev);
        model.addAttribute("np_order", BalgreConstants.NAVER_PAY_ORDER);
        model.addAttribute("iamport", BalgreConstants.IAMPORT_CODE);
        
        String deviceType = (String) session.getAttribute("deviceType");
        System.out.println(deviceType);
        if(deviceType.equals("mobile")) {
        	return "/basket/m_cart";
        }
        return "/basket/cart";

    }
    
    @RequestMapping(value = "/getBasketList", method = RequestMethod.GET)
    @ResponseBody
    public AppBasketResponse basketList(HttpSession session) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");

        return basketService.basketList(login.getToken());
    }

    @RequestMapping(value = "/basketAdd", method = RequestMethod.POST)
    @ResponseBody
    public String basketAddPOST(HttpSession session, HttpServletRequest request) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");

        Map<String, String[]> param = request.getParameterMap();
        String[] itemsVm = request.getParameterValues("items[]");

        for (String item : itemsVm) {
            long itemEach = Long.parseLong(param.get("upDown[" + item + "]")[0].toString());
            long itemId = Long.parseLong(item.toString());

            basketService.basketAdd(login.getToken(), /*itemPrice, */ itemId, itemEach);
        }
        
        return "basketSucc";

    }

    @RequestMapping(value = "/basketDirectPayPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String basketPayPageGETPOST() throws Exception {

        return "/basket/basketPay";

    }

    @RequestMapping(value = "/basketDelete", method = RequestMethod.POST)
    @ResponseBody
    public AppBasketResponse basketDelete(HttpSession session, @RequestParam("basketId") Long basket_id[]) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        System.out.println(basket_id);
        for(Long a : basket_id) {
        	System.out.println(a);
        }
        return basketService.basketDelete(login.getToken(), basket_id);

    }

    @RequestMapping(value = "/basketUpdate", method = RequestMethod.POST)
    @ResponseBody
    public AppBasketResponse basketUpdatePUT(HttpSession session,
                                HttpServletRequest request,
                                Model model,
                                BasketResponse basketResponse,
                                @RequestParam("basketId") Long basket_id,
                                @RequestParam("itemCount") int item_count) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        return basketService.basketUpdate(login.getToken(), basket_id, item_count);
    }
    
    @RequestMapping(value = "/basketUpdateChk", method = RequestMethod.POST)
    @ResponseBody
    public AppBasketResponse basketUpdateChk(HttpSession session,
                                Model model,
                                @RequestParam("basketId") Long basket_id[],
                                @RequestParam("checked") int checked) throws Exception {

        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        return basketService.basketUpdateCheck(login.getToken(), basket_id, checked);
    }

}