package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.Notice;
import net.balgre.domain.NoticeResponse;
import net.balgre.network.NoticeRetroImpl;

@Service
public class NoticeServiceImpl implements NoticeService {

	/*notice list*/
	@Override
	public NoticeResponse noticeList1(int page) {
		// TODO Auto-generated method stub
		System.out.println("con->service page : " + page);
		NoticeRetroImpl NRI = new NoticeRetroImpl();
		
		NoticeResponse res = NRI.noticeList2(page);
		System.out.println("retro->service res : " + res);
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			return null;
		}
	}

	/*notice detail*/
	@Override
	public Notice noticeDetail1(long notice_id) {
		// TODO Auto-generated method stub
		System.out.println("con->service notice_id : " + notice_id);
		NoticeRetroImpl NRI = new NoticeRetroImpl();
		
		Notice res = NRI.noticeDetail2(notice_id);
		System.out.println("retro->service res : " + res);
		if (res == null) {
			
			return null;
		}
		if (res.getId() != 0) {
			
			return res;
		}
		return null;
	}
	

}
