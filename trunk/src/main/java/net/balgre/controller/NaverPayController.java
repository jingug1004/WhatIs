package net.balgre.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.BalgreConstants;
import net.balgre.service.NaverPayOrder;
import net.balgre.service.NaverPayWishlist;
import net.balgre.service.NaverPayOrder.ItemStack;
import net.balgre.service.NaverPayWishlist.WishItemStack;

@Controller
@RequestMapping("/naverpay")
public class NaverPayController {
	
	@Value("${server.image.url}")
	private String imgUrl;
	
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	@ResponseBody
	public String order(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		Map<String, String[]> param = request.getParameterMap();
		String[] itemsVm = request.getParameterValues("items[]");
		String prodName = request.getParameter("prodName");
		String prodId = request.getParameter("prodId");
		int freeDelivery = Integer.parseInt(request.getParameter("freeDelivery").toString());
		int deliveryPrice = Integer.parseInt(request.getParameter("deliveryPrice").toString());
		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<ItemStack> items = new ArrayList<ItemStack>();
		int totalPrice = 0;
		for (String item : itemsVm) {
			int itemEach = Integer.parseInt(param.get("upDown[" + item + "]")[0].toString());
			int itemUPrice = Integer.parseInt(param.get("items[" + item + "].price")[0].toString());
			int itemTPrice = itemUPrice*itemEach;
			String itemName = param.get("itemName[" + item + "]")[0].toString();

			items.add(new ItemStack(prodId, prodName, itemTPrice, itemUPrice, itemName, item, itemEach));  
			totalPrice += itemUPrice;
		}
		int shippingPrice = 0;         
		String shippingType = ""; 
		if(freeDelivery == -1) {
			shippingPrice = deliveryPrice;
			shippingType = "PAYED";
		} else if(freeDelivery == 0) {
			shippingPrice = 0;
			shippingType = "FREE";
		} else {
			if(totalPrice >= freeDelivery) {
				shippingPrice = 0;
				shippingType = "FREE";
			} else {
				shippingPrice = deliveryPrice;
				shippingType = "PAYED";
			}
		}
		String uri = request.getScheme() + "://" +   request.getServerName() +  ":" + request.getServerPort();
		
		String backURL = uri + "/detail?product_id=" + prodId;         
		String nvadId="11111+aa12345678901234";  //CTS          
		//      		//servlet인 경우 쿠키값을 넣어야 함         
		//      		         
		//      		// CPA 스크립트 가이드 설치 업체는 해당 값 전달
		NaverPayOrder npOrder = new NaverPayOrder("https://test-pay.naver.com/customer/api/order.nhn");         
		////      		String cpaInflowCode = npOrder.getCookieValue((HttpServletRequest)request, "CPAValidator");         
		////      		String naverInflowCode = npOrder.getCookieValue((HttpServletRequest)request, "NA_CO");         
		////      		String nvadId = npOrder.getCookieValue((HttpServletRequest)request, "NVADID");
		//      		System.out.println(nvadId);
		String orderKey = npOrder.sendOrderInfoToNC("balgeure", BalgreConstants.NAVER_PAY_CERT_KEY, items.toArray(new ItemStack[0]), shippingPrice, shippingType, backURL, BalgreConstants.NAVER_PAY_COMMON_CERT_KEY);         //여기서 얻은 orderKey로 NC 결제창에 넘겨 결제를 진행한다.         
		return orderKey;
	}

	@RequestMapping(value = "/basket", method = RequestMethod.POST)
	@ResponseBody
	public String orderBasket(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		Map<String, String[]> param = request.getParameterMap();
		String[] prodIds = request.getParameterValues("np_prodId[]");
		//주문 상품 내역으로 items 데이터를 생성한다.         
		List<ItemStack> items = new ArrayList<ItemStack>();
		for (String prodId : prodIds) {
			String prodName = param.get("np_productName_" + prodId)[0].toString();
			String[] prodItems = param.get("np_items" + prodId);
			for(String prodItem:prodItems) {
				String itemName = param.get("np_itemName" + prodItem)[0].toString();
				int itemEach = Integer.parseInt(param.get("upDown[" + prodItem + "]")[0].toString());
				int itemUPrice = Integer.parseInt(param.get("np_itemPrice" + prodItem)[0].toString());
				int itemTPrice = itemUPrice*itemEach;
				items.add(new ItemStack(prodId, prodName, itemTPrice, itemUPrice, itemName, prodItem, itemEach));  
			}
		}
		int shippingPrice = Integer.parseInt(request.getParameter("np_total_delivery").toString());
		String shippingType = "PAYED";
		if(shippingPrice == 0) {
			shippingType = "FREE";
		}

		String uri = request.getScheme() + "://" +   request.getServerName() +  ":" + request.getServerPort();
		String backURL = uri + "/basketList";         
		String nvadId="11111+aa12345678901234";  //CTS          
//		//      		//servlet인 경우 쿠키값을 넣어야 함         
//		//      		         
//		//      		// CPA 스크립트 가이드 설치 업체는 해당 값 전달
		NaverPayOrder npOrder = new NaverPayOrder(BalgreConstants.NAVER_PAY_ORDER_API);         
//		////      		String cpaInflowCode = npOrder.getCookieValue((HttpServletRequest)request, "CPAValidator");         
//		////      		String naverInflowCode = npOrder.getCookieValue((HttpServletRequest)request, "NA_CO");         
//		////      		String nvadId = npOrder.getCookieValue((HttpServletRequest)request, "NVADID");
//		//      		System.out.println(nvadId);
		String orderKey = npOrder.sendOrderInfoToNC("balgeure", BalgreConstants.NAVER_PAY_CERT_KEY, items.toArray(new ItemStack[0]), shippingPrice, shippingType, backURL, BalgreConstants.NAVER_PAY_COMMON_CERT_KEY);         //여기서 얻은 orderKey로 NC 결제창에 넘겨 결제를 진행한다.         
		System.out.println(orderKey);     
		return orderKey;
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
