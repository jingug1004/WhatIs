package net.balgre.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.balgre.domain.AttendanceInfo;
import net.balgre.domain.AttendanceResponse;
import net.balgre.domain.Event;
import net.balgre.network.EventRetroImpl;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
	private EventRetroImpl retro = null;
	
	public EventServiceImpl() {
		super();
		retro = new EventRetroImpl();
	}

	@Override
	public List<Event> eventList() {
		return retro.eventList();
	}

	@Override
	public Event eventDetail(Long eid) {
		return retro.eventDetail(eid);
	}

	@Override
	public AttendanceResponse attendance(String token) {
		return retro.attendance(token);
	}

	@Override
	public AttendanceInfo attendanceInfo(String token) {
		return retro.attendanceInfo(token);
	}

	@Override
	public AttendanceResponse attendanceList(String token) {
		return retro.attendanceList(token);
	}

	@Override
	public AttendanceResponse stamp(String token, Long st_id) {
		return retro.stamp(token, st_id);
	}

}
