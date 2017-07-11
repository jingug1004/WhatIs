package net.balgre.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.balgre.domain.Notice;
import net.balgre.domain.NoticeResponse;
import net.balgre.service.NoticeService;

@Controller
public class NoticeController {
	
	private final static Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	NoticeService noticeService;
	
	/*notice list*/
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String noticeList(Model model, int page) {
		logger.info("view->con page : " + page);
		NoticeResponse res = noticeService.noticeList1(page);
		logger.info("retro->con res : " + res);
		model.addAttribute("notice", res);
		
		return "/notice/noticeList";
	}
	
	
	/*notice detail*/
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public String noticeDetail(Model model, long notice_id) {
		
		logger.info("view->con notice_id : " + notice_id);
		Notice res = noticeService.noticeDetail1(notice_id);
		logger.info("retro->con res : " + res);
		model.addAttribute("noticeD", res);
		
		return "/notice/noticeDetail";
	}
}
