package net.balgre.controller;

import net.balgre.BalgreConstants;

import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.PaymentService;
import org.apache.velocity.tools.generic.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public String order(HttpSession session, HttpServletRequest request, Model model) {
        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");

        Map<String, String[]> param = request.getParameterMap();
        String[] itemsVm = request.getParameterValues("items[]");
        List<PaymentOrder> itemList = new ArrayList<>();
        PaymentOrder paymentOrder;
        for (String item : itemsVm) {
            paymentOrder = new PaymentOrder();
            long itemEach = Long.parseLong(param.get("upDown[" + item + "]")[0].toString());

            paymentOrder.setItemId(item);
            paymentOrder.setItemCnt(itemEach);
            paymentOrder.setItemPrice(0);
            itemList.add(paymentOrder);
            
        }

        return paymentService.initOrder(login.getToken(), itemList);

    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String buy(HttpSession session, @RequestParam("q") String order_id, Model model, String token) {
        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        if (login != null) {
        	
            OrderResponse orderResponse = paymentService.getPayment(login.getToken(), order_id);
            model.addAttribute("imgHost", BalgreConstants.IMAGE_HOST);
            model.addAttribute("iamport", BalgreConstants.IAMPORT_CODE);
            model.addAttribute("username", orderResponse.getUsername());    // 이름
            model.addAttribute("orderTotal", orderResponse.getOrderTotal());    // 주문 정보
            model.addAttribute("myPoint", orderResponse.getMyPoint());    // 내 포인트
            model.addAttribute("maxPoint", orderResponse.getMaxPoint());    // 최대 포인트
            model.addAttribute("coupon", orderResponse.getOrderTotal().getOrderCoupon());    // 일반쿠폰 목록
            model.addAttribute("coupon_count", orderResponse.getOrderTotal().getOrderCoupon().size());    // 일반쿠폰 목록
            model.addAttribute("overlap", orderResponse.getOverlap_cp());    // 중복쿠폰 목록
            model.addAttribute("overlap_count", orderResponse.getOverlap_cp().size());
            model.addAttribute("shipping", orderResponse.getShipping());    // 주소목록
        }
        String deviceType = (String) session.getAttribute("deviceType");
        if(deviceType.equals("mobile")) {
        	return "/payment/m_order";
        }
        return "/payment/order";
    }
    


    @RequestMapping(value = "/order_valid", method = RequestMethod.POST)
    @ResponseBody
    public PaymentResponse orderValid(HttpSession session, @RequestBody OrderValid orderValid, Model model) {
        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        
        return paymentService.orderValid(login.getToken(), orderValid);

    }

    /*호출과 리턴페이지가 같을 경우에는 굳이 String 타입으로 리턴을 해줄 필요 없다.
    void 메서드지만 밑에 model은 매핑된 url로 리턴을 해주고 있다.*/
    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public void complate(HttpSession session, @RequestParam("payment_id") String payment_id,
                         @RequestParam("imp_id") String imp_id, @RequestParam("merchant_id") String merchant_id, Model model) {
        LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
        if (login != null) {
            PaymentResponse paymentResponse = paymentService.complete(login.getToken(), payment_id, imp_id, merchant_id);
            if (paymentResponse.getResultCode().equals("200")) {
                model.addAttribute("complete", paymentResponse);
            }
        }

    }
    
}

class AugmentedDateTool extends DateTool {
    public Date epochToDate(String msSinceEpoch) {
        return new Date(Long.parseLong(msSinceEpoch));
    }
}