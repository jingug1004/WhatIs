package net.balgre.network;

import net.balgre.domain.Notice;
import net.balgre.domain.NoticeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NoticeRetro {
	
	/*notice list*/
	@GET("/api/notice/list/{page}")
	Call<NoticeResponse> noticeList (
		@Path("page") int page
	);
	
	/*notice detail*/
	@GET("/api/notice/{notice_id}")
	Call<Notice> noticeDetail (
		@Path("notice_id") long notice_id
	);
}
