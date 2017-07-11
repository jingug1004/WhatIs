package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:50
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 회원 GET /api/user/send_sms   GET /api/user/sms_cert
 */

@Data
public class CommonResponse {

    private String message;
    private String resultCode;
    private String timestamp;

}
