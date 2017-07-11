package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:42
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 회원 POST /api/user/device_info
 */

@Data
public class DeviceInfo {

    private String appVersion;
    private String deviceId;
    private String modelName;
    private String os;
    private String osVersion;
    private String regDate;
    private String token;

}
