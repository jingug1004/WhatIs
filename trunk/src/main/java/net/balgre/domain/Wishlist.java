package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 2:52
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 */

@Data
public class Wishlist {

    private Product product;
    private String regDate;
    private Integer wishId;

}
