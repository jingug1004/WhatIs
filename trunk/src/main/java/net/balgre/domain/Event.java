package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 4:38
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 이벤트 GET /api/event   GET /api/event/{page}
 * 쿠폰 GET /api/coupon/list
 */

@Data
public class Event {

    private String content;
    private Integer eid;
    private Integer etype;
    private String regDate;
    private Integer sort;
    private Integer stopEvent;
    private String thumbnail;
    private Integer tid;

}
