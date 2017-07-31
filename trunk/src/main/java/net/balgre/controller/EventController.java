package net.balgre.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.BalgreConstants;
import net.balgre.domain.AttendanceInfo;
import net.balgre.domain.AttendanceResponse;
import net.balgre.domain.CouponUserResponse;
import net.balgre.dto.LoginDTO02;
import net.balgre.service.CouponService;
import net.balgre.service.EventService;

/**
 * @author user
 *
 */
@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private CouponService couponService;
	
	/**
	 * 이벤트 상세
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String eventDetail(Model model, @RequestParam("eid") Long eid) {
		
		String menuCheck = "8";
		
		model.addAttribute("event", eventService.eventDetail(eid));
		model.addAttribute("imgHost", BalgreConstants.IMAGE_HOST);
		model.addAttribute("menuCheck", menuCheck);
		
		return "/event/detail";
	}
	
	
	/**
	 * 이벤트 목록
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void eventList(Model model) {
		
		String menuCheck = "8";
		
		model.addAttribute("event", eventService.eventList());
		model.addAttribute("imgHost", BalgreConstants.IMAGE_HOST);
		model.addAttribute("menuCheck", menuCheck);
	}
	
	
	/**
	 * 쿠폰 가져오기 
	 */
	@RequestMapping(value="/download_coupon", method = RequestMethod.POST)
	@ResponseBody
	public String getCoupon(Model model, HttpSession session, @RequestParam("cp_id") String cp_id) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		CouponUserResponse cuRes = couponService.myCouponInsert2(login.getToken(), cp_id);
		if(cuRes == null) {
			return "99";
		} else {
			return cuRes.getResultCode();
		}
	}

	
	/**
	 * 출석체크 상세 
	 */
	@RequestMapping(value="/att_info", method = RequestMethod.GET)
	public void getAttendance(Model model, HttpSession session) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		if(login != null) {
			AttendanceInfo attInfo = eventService.attendanceInfo(login.getToken());
			AttendanceResponse res = eventService.attendanceList(login.getToken());
			
			model.addAttribute("attInfo", attInfo);
			model.addAttribute("attendance", res);
			model.addAttribute("imgHost", BalgreConstants.IMAGE_HOST);
		}
	}
	
	
	/**
	 * 출석체크 하기
	 */
	@RequestMapping(value="/attendance", method = RequestMethod.POST)
	@ResponseBody
	public AttendanceResponse attendance(Model model, HttpSession session) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		AttendanceResponse attRes = eventService.attendance(login.getToken());
		return attRes;
	}
	
	/**
	 * 응모하기 
	 */
	@RequestMapping(value="/stamp", method = RequestMethod.POST)
	@ResponseBody
	public AttendanceResponse stamp(Model model, HttpSession session, @RequestParam("st_id") Long st_id) {
		LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
		AttendanceResponse attRes = eventService.stamp(login.getToken(), st_id);
		return attRes;
	}
	
	
}
