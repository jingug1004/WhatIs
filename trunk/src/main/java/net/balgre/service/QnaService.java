package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.Qna;
import net.balgre.domain.QnaListResponse;
import net.balgre.domain.UserResponse;

public interface QnaService {
	
	// 2. qnaInsertImpl class에서 현 메서드 재정의
	/*qna insert*/
	public CommonResponse qnaInsert1(Qna qna, String token);
	
	/*qna list response*/
	public QnaListResponse qnaListResponse(String token);
	
	/*qna get user info*/
	public UserResponse getUserInfo(String token);
	
	/*qna delete*/
	public QnaListResponse qnaDelete(String token, int id);

}
