package net.balgre.network;

import java.util.List;

import net.balgre.domain.AttendanceInfo;
import net.balgre.domain.AttendanceResponse;
import net.balgre.domain.Event;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface EventRetro {
	

	
	@GET("/api/event/list")
	Call<List<Event>> eventList();
	
	@GET("/api/event")
	Call<Event> eventDetail(@Query("eid") Long eid);
	
	
	// 당월 출석체크
	@PUT("/api/v1/event/attendance")
	Call<AttendanceResponse> attendance(
			@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType);
	
	// 출석체크 정보
	@GET("/api/v1/event/attendance_info")
	Call<AttendanceInfo> attendanceInfo(
			@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType);
	
	// 당월 출석체크
	@GET("/api/v1/event/attendance_list")
	Call<AttendanceResponse> attendanceList(
			@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType);
	
	// 스탬프 교환
	@POST("/api/v1/event/stamp")
	Call<AttendanceResponse> stamp(
			@Header("X-Authorization") String token,
    		@Header("Content-Type") String contentType,
    		@Query("st_id") Long st_id);

}
