package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 3:17
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 * 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail   GET /api/v1/product/list/{page}   GET /api/v1/product/list/{parent}/{page}
 * 이벤트 - 로그인시 해당 API 사용 PUT /api/v1/event/attendance   GET /api/v1/event/attendance_list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 * 회원 - POST /api/user/join
 */

@Data
public class User {

    private Integer age;
    private Integer birthday;
    private String delYn;
    private String email;
    private String emailAgree;
    private String firstCoupon;
    private String gender;
    private String joinType;
    private String password;
    private String myCode;
    private String name;
    private String phone;
    private String profile;
    private String regDate;
    private Integer skinType;
    private String smsAgree;
    private String userId;
    private String sns_id;
    private boolean kakao;
    private boolean naver;
    private boolean facebook;

}
