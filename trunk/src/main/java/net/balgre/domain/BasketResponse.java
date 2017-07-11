package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 4:57
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 장바구니 - 로그인 필요 POST /api/v1/basket/add   DELETE /api/v1/basket/delete   GET /api/v1/basket/list   PUT /api/v1/basket/update
 */

@Data
public class BasketResponse {

    private Object basketList;
    private String message;
    private String resultCode;
    private String timestamp;

}
