package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:01
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 쿠폰 GET /api/coupon/list
 */

@Data
public class EventCoupon {

    private Coupon coupon;
    private Integer ecId;
    private Event event;

}
