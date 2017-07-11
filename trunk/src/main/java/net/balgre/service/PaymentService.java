package net.balgre.service;

import java.util.List;

import net.balgre.domain.Order;
import net.balgre.domain.OrderResponse;
import net.balgre.domain.OrderValid;
import net.balgre.domain.PaymentOrder;
import net.balgre.domain.PaymentResponse;
import net.balgre.domain.Payments;

public interface PaymentService {

	public String initOrder(String token, List<PaymentOrder> itemList);
	public OrderResponse getPayment(String token, String order_id);
	public PaymentResponse orderValid(String token, OrderValid orderValid);
	public PaymentResponse complete(String token, String payment_id, String imp_id, String merchant_id);
	
	public List<Payments> myOrder(String token);
	public Order myOrderDetail(String token, String payment_id);
	public PaymentResponse orderCancel(String token, String payment_id);
}
