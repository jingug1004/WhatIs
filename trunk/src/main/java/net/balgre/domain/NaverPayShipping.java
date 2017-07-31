package net.balgre.domain;

import lombok.Data;

@Data
public class NaverPayShipping {
	
	private String groupId; // : "",
	private String method; // : "DELIVERY", //DELIVERY(택배·소포·등기), QUICK_SVC(퀵 서비스), DIRECT_DELIVERY(직접 전달), VISIT_RECEIPT(방문 수령), NOTHING(배송 없음)
	private int baseFee; // : 0,
	private String feeType; //: "FREE", //FREE(무료), CHARGE(유료), CONDITIONAL_FREE(조건부 무료), CHARGE_BY_QUANTITY(수량별 부과)
	private String feePayType; // : "FREE" //FREE(무료), PREPAYED(선불), CASH_ON_DELIVERY(착불)
	private NaverPayFeeRule feeRule;
}
