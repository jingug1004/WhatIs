package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 3:13
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 * 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail   GET /api/v1/product/list/{page}   GET /api/v1/product/list/{parent}/{page}
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class ProductDelivery {

    private DeliveryCompany deliveryCompany;
    private Integer deliveryDate;
    private Integer deliveryId;
    private Integer deliveryPrice;
    private Integer freeDelivery;
    private Integer shippingType;
    private String uniqueness;

}
