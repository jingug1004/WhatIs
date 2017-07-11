package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class ReviewWait {
	
	private String payDate; // (string, optional): 구매일 ,
	private String paymentId; // (string, optional): 결제 ID ,
	private String point; // (string, optional): 포인트지급 ,
	private Product product; // (Product, optional): 상품 정보 ,
	private int reviewId; // (integer, optional): 리뷰 작성 ID ,
	private List<ReviewWaitItem> reviewWaitItem; // (Array[ReviewWaitItem], optional): 리뷰 옵션 목록 ,
	private String reviewWrite; // (string, optional): 리뷰 작성 여부 ,
	private User user; // (UserService, optional): 유저 ,
	private int waitId; // (integer, optional)

}
