package net.balgre.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2017-04-07 오후 5:03
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 쿠폰 GET /api/coupon/list
 */

@Data
public class EventCouponResponse {

    private List<EventCoupon> couponList;
    private String message;
    private String resultCode;
    private String timestamp;

}
