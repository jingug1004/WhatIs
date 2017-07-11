package net.balgre.domain;

import lombok.Data;

@Data
public class PaymentItem {
	
	private int amount; // (integer, optional): 판매금액 ,
	private String buyer_addr; // (string, optional): 주문자 주소 ,
	private String buyer_email; // (string, optional): 주문자 Email주소 ,
	private String buyer_name; // (string, optional): 주문자명 ,
	private String buyer_postcode; // (string, optional): 주문자 우편번호 ,
	private String buyer_tel; // (string, optional): 주문자 전화번호 ,
	private int couponDiscount; // (integer, optional): 할인금액 ,
	private String couponId; // (string, optional): 쿠폰ID 
	private String deliveryCode; // (string, optional): 택배사 코드 ,
	private String deliveryName; // (string, optional): 택배사 ,
	private String deliveryNumber; // (string, optional): 송장번호 
	private int delivery_pay; // (integer, optional): 택배비용 ,
	private int delivery_type; // (integer, optional): 0:묶음배송 1:무료배송 2:배송료지불 ,
	private ProductItem itemId;
	private String itemName; // (string, optional): 주문 옵션명 ,
	private String note; // (string, optional): 배송 요청사항 ,
	private int orderCount; // (integer, optional): 주문수량 ,
	private int payment; // (integer, optional): 구매 금액 ,
	private String paymentId; // (string, optional): 주문ID ,
	private int piId; // (integer, optional): 결제 상품 ,
	private int prodConfirm; // (integer, optional): 상품 확인 [0 : 미확인 , 1 : 확인] ,
	private String prodName; // (string, optional): 주문 상품 명 ,
	private String regDate; // (string, optional): 등록일 ,
	private String status; // (string, optional): 결제상태. ready:미결제, paid:결제완료, cancelled:결제취소, failed:결제실패 = ['ready', 'paid', 'cancelled', 'failed'] ,
	private int supply_price; // (integer, optional): 공급가 ,
	private User user; // 판매자ID

}
