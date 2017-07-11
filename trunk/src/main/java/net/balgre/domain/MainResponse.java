package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class MainResponse {
	
	private List<MainFirstBanner> mainFirstBanner; // (Array[MainFirstBanner], optional): 첫번째배너 ,
	private List<MainMenu> mainMenu; // (Array[MainMenu], optional): 메인 메뉴 ,
	private List<MainSecondBanner> mainSecondBanner; // (Array[MainSecondBanner], optional): 두번째배너 ,
	private List<MainTenMenu> mainTenMenu; // (Array[MainTenMenu], optional): 메인 10개 메뉴 ,
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private List<Product> productList; // (Array[Product], optional): 실시간 인기 목록 ,
	private String resultCode; // (string, optional): 200 성공 99 업데이트 필요 = ['200', '99'],
	private String timestamp; // (string, optional)

}
