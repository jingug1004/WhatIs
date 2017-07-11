package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:16
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 쿠폰 GET /api/coupon/list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class SpecialCoupon {

    private String cpId;
    private Integer ctId;
    private Integer spId;

}
