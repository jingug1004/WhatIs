package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class Payments {
	
	private int amount; // (number, optional): 주문(결제)금액 ,
	private String apply_num; // (string, optional): 카드사 승인정보(계좌이체/가상계좌는 값 없음) ,
	private String buyer_addr; // (string, optional): 주문자 주소 ,
	private String buyer_email; // (string, optional): 주문자 Email주소 ,
	private String buyer_name; // (string, optional): 주문자명 
	private String buyer_postcode; // (string, optional): 주문자 우편번호 ,
	private String buyer_tel; // (string, optional): 주문자 전화번호 ,
	private int cancel_amount; // (number, optional): 결제취소금액 ,
	private String cancel_reason; // (string, optional): 결제취소 사유 ,
	private String cancelled_at; // (string, optional): 결제취소시점 UNIX timestamp. 결제취소가 아닐 경우 0 ,
	private String card_name; // (string, optional): 카드사 명칭 ,
	private int card_quota; // (integer, optional): 할부개월 수(0이면 일시불) ,
	private int couponDiscount; // (integer, optional): 중복쿠폰 할인액 ,
	private String pcouponId; // (string, optional): 중복쿠폰 ID ,
	private boolean escrow; // (boolean, optional): 에스크로결제 여부 ,
	private String fail_reason; // (string, optional): 결제실패 사유  ,
	private String failed_at; // (string, optional): 결제실패시점 UNIX timestamp. 결제실패가 아닐 경우 0 ,
	private String impUid; // (string, optional): 아임포트 ID ,
	private String merchantUid; // (string, optional): 가맹점에서 전달한 거래 고유 UID ,
	private String name; // (string, optional): 주문명칭 ,
	private String note; // (string, optional): 배송 요청 사항 ,
	private int paidProc; // (integer, optional): 완료 처리 여부 [0 : 미처리 , 1 : 처리] ,
	private String paid_at; // (string, optional): 결제완료시점 UNIX timestamp. 결제완료가 아닐 경우 0 ,
	private String pay_method; // (string, optional): samsung : 삼성페이 / card : 신용카드 / trans : 계좌이체 / vbank : 가상계좌 ,
	private String paymentId; // (string, optional): 결제 ID ,
	private List<PaymentItem> paymentItem; // (Array[PaymentItem], optional): 결제 옵션 목록 ,
	private String pg_provider; // (string, optional): PG사 명칭. inicis(이니시스) / nice(나이스정보통신) ,
	private String pg_tid; // (string, optional): PG사 승인정보 ,
	private int pointDiscount; // (integer, optional): 포인트할인금액 ,
	private int pointYn; // (integer, optional): 포인트지급여부 [0 : 미지급 , 1 : 지급] ,
	private String receipt_url; // (string, optional): 신용카드 매출전표 확인 URL ,
	private String refund_account; // (string, optional): 환불계좌 계좌번호 ,
	private String refund_bank; // (string, optional): 환불계좌 은행코드 ,
	private String refund_holder; // (string, optional): 환불계좌 예금주 ,
	private Long regDate; // (string, optional): 주문일 ,
	private String status; // (string, optional): 결제상태. ready:미결제, paid:결제완료, cancelled:결제취소, failed:결제실패 = ['ready', 'paid', 'cancelled', 'failed'] ,
	private int totalPayment; // (integer, optional): 총 결제금액 ,
	private User user; // (UserService, optional): 구매자ID ,
	private Long vbank_date; // (string, optional): 입금받을 가상계좌 마감기한 UNIX timestamp ,
	private String vbank_holder; // (string, optional): 입금받을 가상계좌 예금주 ,
	private String vbank_name; // (string, optional): 입금받을 가상계좌 은행명 ,
	private String vbank_num; // (string, optional): 입금받을 가상계좌 계좌번호
	
}
