package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 2:54
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail   GET /api/v1/product/list/{page}   GET /api/v1/product/list/{parent}/{page}
 * 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 *
 */

@Data
public class Product {

    private String banner;
    private Integer box;
    private Brand brand;
    private String content;
    private String detailUrl;
    private Integer price;
    private String prodDesc;
    private String prodName;
    private ProductDelivery productDelivery;
    private long productId;
    private String regDate;
    private Integer reviewCount;
    private Number reviewStar;
    private Integer sale;
    private Integer salePrice;
    private Integer score;
    private User seller;
    private Integer star1;
    private Integer star2;
    private Integer star3;
    private Integer star4;
    private Integer star5;
    private Integer stopSelling;
    private String thumbUrl;
    private Integer timeSale;
    private Integer viewCount;
    private Integer autoSale;
}