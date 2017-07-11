package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class QnaListResponse {
	
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private List<Qna> qnaList; // (Array[Qna], optional): Qna리스트 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private String timestamp; // (string, optional)

}
