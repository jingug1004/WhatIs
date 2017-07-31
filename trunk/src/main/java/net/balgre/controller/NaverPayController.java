package net.balgre.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.BalgreConstants;
import net.balgre.domain.NaverPayFeeRule;
import net.balgre.domain.NaverPayOption;
import net.balgre.domain.NaverPayOptionSelections;
import net.balgre.domain.NaverPayProduct;
import net.balgre.domain.NaverPayShipping;
import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.NaverPayWishlist;
import net.balgre.service.NaverPayWishlist.WishItemStack;
import net.balgre.service.PaymentService;

@Controller
@RequestMapping("/naverpay")
public class NaverPayController {

	@Value("${server.image.url}")
	private String imgUrl;

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderBuy(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		LoginDTO02 login = (LoginDTO02) session.getAttribute("login");

		Map<String, String[]> param = request.getParameterMap();
		String[] itemsVm = request.getParameterValues("items[]");

		List<PaymentOrder> itemList = new ArrayList<>();
		PaymentOrder paymentOrder;

		List<NaverPayProduct> npList = new ArrayList<>();
		NaverPayProduct np = new NaverPayProduct();
		String prodId = request.getParameter("prodId");				// 상품 고유 ID
		String prodName = request.getParameter("prodName");			// 상품 명
		int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		String thumbUrl = request.getParameter("thumbUrl");
		String uri = "http://balgeure.co.kr";
		String backURL = uri + "/detail?product_id=" + prodId;   
		np.setId(prodId);
		np.setName(prodName);
		np.setBasePrice(prodPrice);
		np.setInfoUrl(backURL);
		np.setImageUrl(imgUrl + thumbUrl);


		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<NaverPayOption> items = new ArrayList<NaverPayOption>();
		NaverPayOption npo = null;

		List<NaverPayOptionSelections> npoSelections = null;
		NaverPayOptionSelections npsSelection = null;
		for (String item : itemsVm) {
			paymentOrder = new PaymentOrder();
			int itemEach = Integer.parseInt(param.get("upDown[" + item + "]")[0].toString());

			paymentOrder.setItemId(item);
			paymentOrder.setItemCnt(itemEach);
			paymentOrder.setItemPrice(0);
			itemList.add(paymentOrder);

			npo = new NaverPayOption();
			npoSelections = new ArrayList<NaverPayOptionSelections>();
			npsSelection = new NaverPayOptionSelections();
			
			int itemUPrice = Integer.parseInt(param.get("items[" + item + "].price")[0].toString());
			int itemTPrice = itemUPrice-prodPrice;

			String itemName = param.get("itemName[" + item + "]")[0].toString();
			npsSelection.setCode(item);
			npsSelection.setLabel("선택");
			npsSelection.setValue(itemName);
			npoSelections.add(npsSelection);

			npo.setOptionQuantity(itemEach);
			npo.setSelectionCode(item);
			npo.setSelections(npoSelections);
			npo.setOptionPrice(itemTPrice);
			items.add(npo);
		}


		NaverPayShipping nps = new NaverPayShipping();
		nps.setMethod("DELIVERY");

		int freeDelivery = Integer.parseInt(request.getParameter("freeDelivery").toString());
		int deliveryPrice = Integer.parseInt(request.getParameter("deliveryPrice").toString());
		nps.setGroupId(request.getParameter("prodSeller").toString());
		if(freeDelivery == -1) {
			nps.setBaseFee(deliveryPrice);
			nps.setFeeType("CHARGE");
			nps.setFeePayType("PREPAYED");
		} else if(freeDelivery == 0) {
			nps.setBaseFee(0);
			nps.setFeeType("FREE");
			nps.setFeePayType("FREE");
		} else {
			nps.setBaseFee(deliveryPrice);
			nps.setFeeType("CONDITIONAL_FREE");
			nps.setFeePayType("PREPAYED");
			NaverPayFeeRule npfr = new NaverPayFeeRule();
			npfr.setFreeByThreshold(freeDelivery);
			nps.setFeeRule(npfr);
		}

		np.setOptions(items);
		np.setShipping(nps);
		//		np.setQuantity(quantity);
		npList.add(np);
		
		String orderId = paymentService.initOrder(login.getToken(), itemList);
		OrderResponse orderResponse = paymentService.getPayment(login.getToken(), orderId);

		OrderValid ov = new OrderValid();
		ov.setTotalPayment((int)(long)(orderResponse.getOrderTotal().getTotalPrice() + orderResponse.getOrderTotal().getTotalDelivery()));
		ov.setOrderId(orderId);
		ov.setUsePoint(0);
		ov.setOverlapCpDis(0);
		ov.setName(orderResponse.getShipping().get(0).getName());
		ov.setZipcode(orderResponse.getShipping().get(0).getZipcode());
		ov.setAddress1(orderResponse.getShipping().get(0).getAddress1());
		ov.setAddress2(orderResponse.getShipping().get(0).getAddress2());
		ov.setPhone(orderResponse.getShipping().get(0).getPhone());
		ov.setMemo("");
		
		PaymentResponse paymentResponse = paymentService.orderValid(login.getToken(), ov);
		
		Map<String, Object> map = new HashMap<>();
	
		map.put("payment", paymentResponse.getPayment());
		map.put("npList", npList);
		
		return map;
	}

	@RequestMapping(value = "/basket", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderBasket(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		LoginDTO02 login = (LoginDTO02) session.getAttribute("login");
		Map<String, String[]> param = request.getParameterMap();
		String[] prodIds = request.getParameterValues("np_prodId[]");
		String uri = "http://balgeure.co.kr";

		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<NaverPayProduct> npList = new ArrayList<>();
		NaverPayProduct np = null;

		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<NaverPayOption> items=  null;
		NaverPayOption npo = null;

		List<NaverPayOptionSelections> npoSelections = null;
		NaverPayOptionSelections npsSelection = null;

		NaverPayShipping nps = null;
		NaverPayFeeRule npfr = null;
		
		List<PaymentOrder> itemList = new ArrayList<>();
		PaymentOrder paymentOrder;
		
		for (String prodId : prodIds) {
			np = new NaverPayProduct();
			items = new ArrayList<NaverPayOption>();
			String prodName = param.get("np_productName_" + prodId)[0].toString();			// 상품 명np_prodPrice_
			int prodPrice = Integer.parseInt(param.get("np_prodPrice_" + prodId)[0].toString());
			String thumbUrl = param.get("np_thumbUrl_" + prodId)[0].toString();
			String infoURL = uri + "/detail?product_id=" + prodId;   
			np.setId(prodId);
			np.setName(prodName);
			np.setBasePrice(prodPrice);
			np.setInfoUrl(infoURL);
			np.setImageUrl(imgUrl + thumbUrl);
			String[] prodItems = param.get("np_items" + prodId);
			for(String prodItem:prodItems) {
				paymentOrder = new PaymentOrder();
				int itemEach = Integer.parseInt(param.get("upDown[" + prodItem + "]")[0].toString());

				paymentOrder.setItemId(prodItem);
				paymentOrder.setItemCnt(itemEach);
				paymentOrder.setItemPrice(0);
				itemList.add(paymentOrder);
				
				npo = new NaverPayOption();
				npoSelections = new ArrayList<NaverPayOptionSelections>();
				npsSelection = new NaverPayOptionSelections();

				
				int itemUPrice = Integer.parseInt(param.get("np_itemPrice" + prodItem)[0].toString());
				int itemTPrice = prodPrice-itemUPrice;
				
				String itemName = param.get("np_itemName" + prodItem)[0].toString();
				npsSelection.setCode(prodItem);
				npsSelection.setLabel("선택");
				npsSelection.setValue(itemName);
				npoSelections.add(npsSelection);

				npo.setOptionQuantity(itemEach);
				npo.setSelectionCode(prodItem);
				npo.setSelections(npoSelections);
				npo.setOptionPrice(itemTPrice);
				items.add(npo);
			}

			nps = new NaverPayShipping();
			nps.setMethod("DELIVERY");
			
			int freeDelivery = Integer.parseInt(param.get("np_freeDelivery_" + prodId)[0].toString());
			int deliveryPrice = Integer.parseInt(param.get("np_deliveryPrice_" + prodId)[0].toString());
			nps.setGroupId(param.get("np_seller_" + prodId)[0].toString());
			if(freeDelivery == -1) {
				nps.setBaseFee(deliveryPrice);
				nps.setFeeType("CHARGE");
				nps.setFeePayType("PREPAYED");
			} else if(freeDelivery == 0) {
				nps.setBaseFee(0);
				nps.setFeeType("FREE");
				nps.setFeePayType("FREE");
			} else {
				nps.setBaseFee(deliveryPrice);
				nps.setFeeType("CONDITIONAL_FREE");
				nps.setFeePayType("PREPAYED");
				npfr = new NaverPayFeeRule();
				npfr.setFreeByThreshold(freeDelivery);
				nps.setFeeRule(npfr);
			}

			np.setOptions(items);
			np.setShipping(nps);

			npList.add(np);
		}
		
		String orderId = paymentService.initOrder(login.getToken(), itemList);
		OrderResponse orderResponse = paymentService.getPayment(login.getToken(), orderId);

		OrderValid ov = new OrderValid();
		ov.setTotalPayment((int)(long)(orderResponse.getOrderTotal().getTotalPrice() + orderResponse.getOrderTotal().getTotalDelivery()));
		ov.setOrderId(orderId);
		ov.setUsePoint(0);
		ov.setOverlapCpDis(0);
		ov.setName(orderResponse.getShipping().get(0).getName());
		ov.setZipcode(orderResponse.getShipping().get(0).getZipcode());
		ov.setAddress1(orderResponse.getShipping().get(0).getAddress1());
		ov.setAddress2(orderResponse.getShipping().get(0).getAddress2());
		ov.setPhone(orderResponse.getShipping().get(0).getPhone());
		ov.setMemo("");
		
		PaymentResponse paymentResponse = paymentService.orderValid(login.getToken(), ov);
		
		Map<String, Object> map = new HashMap<>();
	
		map.put("payment", paymentResponse.getPayment());
		map.put("npList", npList);
		
		return map;
	}
	@RequestMapping(value = "/wish", method = RequestMethod.POST)
	@ResponseBody
	public String naverpayWish(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		String prodName = request.getParameter("prodName");
		String prodDesc = request.getParameter("prodDesc");
		String prodId = request.getParameter("prodId");
		int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		String thumbUrl = imgUrl + request.getParameter("thumbUrl");
		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<WishItemStack> items = new ArrayList<WishItemStack>();
		String uri = request.getScheme() + "://" +   request.getServerName() +  ":" + request.getServerPort();

		String detailURL = uri + "/detail?product_id=" + prodId; 
		items.add(new WishItemStack(prodId, prodName, prodDesc, prodPrice, thumbUrl, thumbUrl, detailURL));   
		NaverPayWishlist npWish = new NaverPayWishlist(BalgreConstants.NAVER_PAY_WISH_API);  
		String[] prodSeqs = npWish.sendZzimToNC("balgeure", BalgreConstants.NAVER_PAY_CERT_KEY, items.toArray(new WishItemStack[0]));         
		//여기서 얻은prodSeqs로 zzim popup을 띄운다.         
		System.out.println(Arrays.toString(prodSeqs));
		return prodSeqs[0];
		//		return paymentService.naverPayment(data);
	} 

	@RequestMapping(value = "/basket_wish", method = RequestMethod.POST)
	@ResponseBody
	public String[] naverpayBasketWish(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		Map<String, String[]> param = request.getParameterMap();
		String[] prodIds = request.getParameterValues("np_prodId[]");
		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<WishItemStack> items = new ArrayList<WishItemStack>();
		String uri = request.getScheme() + "://" +   request.getServerName() +  ":" + request.getServerPort();
		for (String prodId : prodIds) {
			String prodName = param.get("np_productName_" + prodId)[0].toString();
			String prodDesc = param.get("np_prodDesc_" + prodId)[0].toString();
			int prodPrice = Integer.parseInt(param.get("np_prodPrice_" + prodId)[0].toString());
			String thumbUrl = imgUrl + param.get("np_thumbUrl_" + prodId)[0].toString();
			items.add(new WishItemStack(prodId, prodName, prodDesc, prodPrice, thumbUrl, thumbUrl, uri + "/detail?product_id=" + prodId));
		}

		NaverPayWishlist npWish = new NaverPayWishlist(BalgreConstants.NAVER_PAY_WISH_API);  
		String[] prodSeqs = npWish.sendZzimToNC("balgeure", BalgreConstants.NAVER_PAY_CERT_KEY, items.toArray(new WishItemStack[items.size()])); 
		for(String prodSeq:prodSeqs) {
			System.out.println(prodSeq);
		}
		System.out.println(prodSeqs);
		return prodSeqs;
		//		return paymentService.naverPayment(data);
	} 
}
