package net.balgre.domain;

import lombok.Data;

@Data
public class Notice {
	
	private String content; // (string, optional): 내용 ,
	private int id; // (integer, optional),
	private long regDate; // (string, optional): 작성일 ,
	private String subject; // (string, optional): 제목 ,
	private String topYn; // (string, optional): 항상위 ,
	private User user; // (User, optional): 유저 고유ID ,
	private int viewcount; // (integer, optional): 조회수

}
