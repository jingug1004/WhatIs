package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponse2 {
	
	private Object brandList; // (object, optional): 브랜드 List ,
	private List<CategoryLvResult> categoryList; // (Array[CategoryLvResult], optional): 카테고리 List Object[lv1_id, lv1, lv2_id, lv2, lv3_id, lv3] ,
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private String resultCode; // (string, optional): 200 성공 99 실패 = ['200', '99'],
	private String timestamp; // (string, optional)

}
