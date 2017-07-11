package net.balgre.service;

import net.balgre.domain.Notice;
import net.balgre.domain.NoticeResponse;

public interface NoticeService {
	
	public NoticeResponse noticeList1(int page);
	
	public Notice noticeDetail1(long notice_id);

}
