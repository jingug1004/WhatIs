package net.balgre.domain;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 5:53
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 회원 GET /api/user/version/{os_type}
 */

@Data
public class Version {

    private String osType;
    private Integer status;
    private String versionName;
    private Integer versionSeq;


}
