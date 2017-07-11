package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class Review {
	
	private String content; // (string, optional): 내용 ,
	private boolean isLike; // (boolean, optional),
	private boolean like; // (boolean, optional),
	private int likeCount; // (integer, optional): 추천수 ,
	private Product product; // (Product, optional): 상품 정보 ,
	private long regDate; // (string, optional): 등록일 ,
	private int reviewId; // (integer, optional),
	private List<ReviewPhoto> reviewPhoto; // (Array[ReviewPhoto], optional): 리뷰 사진 ,
	private int reviewType; // (integer, optional): 0 일반리뷰 1 포토리뷰 ,
	private String reviewerName; // (string, optional),
	private int skinType; // (integer, optional): 피부타입 0 : 건성, 1 : 중성, 2 : 지성, 3 : 복합성 ,
	private int star; // (integer, optional): 별점 ,
	private User user; // (UserService, optional): 유저 고유ID

}
