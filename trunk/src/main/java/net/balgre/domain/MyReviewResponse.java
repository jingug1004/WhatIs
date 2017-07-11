package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class MyReviewResponse {
	
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private List<Review> myReviewList; // (Array[Review], optional): 작성한 리뷰 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private List<ReviewWait> reviewList; // (Array[ReviewWait], optional): 작성 가능한 리뷰 ,
	private String timestamp; // (string, optional)

}
