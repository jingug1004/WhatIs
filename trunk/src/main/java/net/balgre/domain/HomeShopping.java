package net.balgre.domain;

import java.util.Date;

import lombok.Data;

@Data
public class HomeShopping {

	private Long hsId;
	// 방송제목
	private String hsTitle;
	
	// 방송설명
	private String hsDesc;
	
	// 이미지
	private String thumbnail;
	
    // 방송 시작일
	private long startDate;
    
    // 방송 종료일
	private long endDate;
    
    // 상품
	private Product product;
    
    // 방송 URL
	private String videoUrl;
    
	
}
