package net.balgre.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2017-04-07 오후 5:21
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 쿠폰 - 로그인 필요 POST /api/v1/coupon/my
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class CouponUser {

    private Integer cid;
    private Coupon coupon;
    private String endDate;
    private List<Product> productList;
    private String regDate;
    private String startDate;
    private String useDate;
    private String useYn;
    private User user;

}
