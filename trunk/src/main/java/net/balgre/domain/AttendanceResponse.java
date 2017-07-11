package net.balgre.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2017-04-07 오후 4:44
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 이벤트 - 로그인시 해당 API 사용 PUT /api/v1/event/attendance   GET /api/v1/event/attendance_list
 */

@Data
public class AttendanceResponse {

    private List<Attendance> attendanceList;
    private int stamp;
    private String message;
    private String resultCode;
    private String timestamp;

}
