package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 2:44
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/category
 */

@Data
public class CategoryLvResult {

    private String lv1;
    private String lv1_id;
    private String lv2;
    private String lv2_id;
    private String lv3;
    private String lv3_id;

}
