package net.balgre.domain;

import lombok.Data;

@Data
public class QnaPhoto {
	
	private String photoPath; // (string, optional),
	private int qnaId; // (integer, optional): 1:1문의 ID ,
	private String regDate; // (string, optional)

}
