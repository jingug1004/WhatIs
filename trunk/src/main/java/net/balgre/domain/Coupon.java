package net.balgre.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2017-04-07 오후 5:08
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 쿠폰 GET /api/coupon/list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class Coupon {

    private Integer auto;
    private Integer cpCount;
    private String cpId;
    private String cpName;
    private Integer cpType;
    private Integer download;
    private Integer endAfter;
    private String endDate;
    private Integer endType;
    private Integer maximum;
    private Integer minimum;
    private Integer price;
    private String regDate;
    private Integer saleType;
    private List<SpecialCoupon> spCoupon;

}
