package net.balgre.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.balgre.domain.Brand;
import net.balgre.domain.Order;
import net.balgre.domain.OrderDetail;
import net.balgre.domain.OrderDetailProduct;
import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderTotal;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentItem;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.domain.Payments;
import net.balgre.domain.Product;
import net.balgre.network.PaymentRetroImpl;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public OrderResponse getPayment(String token, String order_id) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		
		OrderResponse orderTotal = retro.getPayment(token, order_id);
		
		return orderTotal;
	}

	@Override
	public String initOrder(String token, List<PaymentOrder> itemList) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		
		OrderTotal orderTotal = retro.order(token, itemList);
		return orderTotal.getOrderId();
	}

	@Override
	public PaymentResponse orderValid(String token, OrderValid orderValid) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		return retro.orderValid(token, orderValid);
	}

	@Override
	public PaymentResponse complete(String token, String payment_id, String imp_id, String merchant_id) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		return retro.orderComplete(token, payment_id, imp_id, merchant_id);
	}

	/*
	 * 내 주문 내역
	 */
	@Override
	public List<Payments> myOrder(String token) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		return retro.myOrder(token);
	}

	/*
	 * 내 주문 내역 상세
	 */
	@Override
	public Order myOrderDetail(String token, String payment_id) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		Payments  payments = retro.myOrderDetail(token, payment_id);
		Order order = new Order();
		order.setBuyer_addr(payments.getBuyer_addr());
		order.setBuyer_name(payments.getBuyer_name());
		order.setBuyer_tel(payments.getBuyer_tel());
		order.setNote(payments.getNote());
		order.setPaymethod(payments.getPay_method());
		order.setStatus(payments.getStatus());
		order.setTotal(payments.getTotalPayment());
		order.setPointDis(payments.getPointDiscount());
		order.setCpDis(payments.getCouponDiscount());
		List<PaymentItem> itemList = payments.getPaymentItem();
		// 브랜드별 분류
		Map<Product, List<PaymentItem>> prodMap = null;
		List<PaymentItem> tmpList = null;
		Map<Brand, Map<Product, List<PaymentItem>>> map = new HashMap<>();

		Map<Brand, String> deliMap = new HashMap<>();
		List<Brand> brandConfirm = new ArrayList<>();
		for(PaymentItem item:itemList) {
			order.setDelivery(order.getDelivery() + item.getDelivery_pay());
			order.setPayment(order.getPayment() + (item.getAmount()*item.getOrderCount()));
			order.setCpDis(payments.getCouponDiscount() + item.getCouponDiscount());
			order.setVBankDate(payments.getVbank_date());
			order.setVBankNum(payments.getVbank_num());
			order.setVBankName(payments.getVbank_name());
			
			Product product = item.getItemId().getProduct();
			Brand brand = product.getBrand();
			
			
			if(item.getProdConfirm() == 1) {
				order.setCancelStatus(false);
				brandConfirm.add(brand);
			}
			
			if(item.getDeliveryNumber() != null && !item.getDeliveryNumber().equals("")) {
				order.setCancelStatus(false);
				deliMap.put(brand, item.getDeliveryNumber());
			}
			
			if(map.containsKey(brand)) {
				// 브랜드가 있다
				prodMap = map.get(brand);
				if(prodMap.containsKey(product)) {
					// 상품이 있다
					tmpList = prodMap.get(product);
					tmpList.add(item);
					prodMap.put(product, tmpList);
				} else {
					//상품이 없다
					tmpList = new ArrayList<>();
					tmpList.add(item);
					prodMap.put(product, tmpList);
				}
			} else {
				// 브랜드가 없다
				tmpList = new ArrayList<>();
				tmpList.add(item);
				prodMap = new HashMap<>();
				prodMap.put(product, tmpList);
				map.put(brand, prodMap);
			}
		}
		
		order.setTotal(order.getTotal() + order.getDelivery());
		
		List<OrderDetail> odList = new ArrayList<>();
		
		Iterator<Brand> keys = map.keySet().iterator();
		OrderDetail od = null;
		List<OrderDetailProduct> odpList = null;
		OrderDetailProduct odp = null;
        while( keys.hasNext() ){
        	od = new OrderDetail();
        	Brand key = keys.next();
        	od.setBrand(key);
        	
        	if(deliMap.containsKey(key)) {
        		od.setDeliveryNumber(deliMap.get(key));
        	}
        	
        	for(Brand brand:brandConfirm) {
        		if(brand.getBrandId() == key.getBrandId()) {
        			od.setProdConfirm(1);
        		}
        	}
        	
        	prodMap = map.get(key);
        	Iterator<Product> pKeys = prodMap.keySet().iterator();
        	odpList = new ArrayList<>();
        	while( pKeys.hasNext() ){
        		Product pKey = pKeys.next();
        		odp = new OrderDetailProduct();
        		odp.setProduct(pKey);
        		odp.setItemList(prodMap.get(pKey));
        		odpList.add(odp);
        	}
        	od.setOrdDtProduct(odpList);
        	odList.add(od);
        }
        
        
        order.setOrderDetail(odList);
		
		return order;
	}

	@Override
	public PaymentResponse orderCancel(String token, String payment_id) {
		PaymentRetroImpl retro = new PaymentRetroImpl();
		PaymentResponse res = retro.orderCancel(token, payment_id);
		return res;
	}
}
