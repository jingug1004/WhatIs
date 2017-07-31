package net.balgre.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Qna {

    private int id; // (integer, optional),
    private String content; // (string, optional): 내용 ,
    private int orderId; // (integer, optional): 주문내역 ,
    private String qnaClass1; // (string, optional): 문의분류1 ,
    private String qnaClass2; // (string, optional): 문의분류2 ,
    private List qnaPhoto; // (Array[QnaPhoto], optional): 문의 이미지 ,
    private String regDate; // (string, optional): 문의날짜 ,
    private String replyDate; // (string, optional): 답변달짜 ,
    private String replyYn; // (string, optional): 답변여부 ,
    private String reply_content; // (string, optional): 답글내용 ,
    private String subject; // (string, optional): 제목 ,
    private User user; // (UserService, optional): 유저 고유ID

}
