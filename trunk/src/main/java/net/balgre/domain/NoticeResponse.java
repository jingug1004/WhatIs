package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class NoticeResponse {
	
	private String message; //(string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private PageNotice noticeList; // (Page«Notice», optional): 일반공지 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99', '10']
	private String timestamp; // (string, optional),
	private List<Notice> topList; // (Array[Notice], optional): 고정공지

}
