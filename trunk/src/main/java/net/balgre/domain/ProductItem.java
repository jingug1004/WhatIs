package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 3:52
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail
 */

@Data
public class ProductItem {

    private String info1;
    private String info2;
    private String info3;
    private String info4;
    private String info5;
    private String info6;
    private String info7;
    private String info8;
    private String info9;
    private String info10;
    private String info11;
    private String info12;
    private String info13;
    private Integer itemCnt;
    private Integer itemId;
    private String itemName;
    private Integer maxItemCnt;
    private Integer price;
    private Product product;
    private String regDate;
    private Integer stopSelling;
    private Integer supply_price;
    private Integer totalItemCnt;

}
