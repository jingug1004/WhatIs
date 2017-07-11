package net.balgre.service;

import java.util.List;

import net.balgre.domain.AttendanceInfo;
import net.balgre.domain.AttendanceResponse;
import net.balgre.domain.Event;
import retrofit2.http.Query;

public interface EventService {

	public List<Event> eventList();
	
	public Event eventDetail(@Query("eid") Long eid);
	
	// 당월 출석체크
	public AttendanceResponse attendance(String token);
	
	// 출석체크 정보
	public AttendanceInfo attendanceInfo(String token);
	
	// 당월 출석체크
	public AttendanceResponse attendanceList(String token);
	
	// 스탬프 교환
	public AttendanceResponse stamp(String token, Long st_id);
}
