package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:46
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 회원 POST /api/user/join
 */

@Data
public class UserResponse {

    private String message;
    private String resultCode;
    private String timestamp;
    private User user;

}
