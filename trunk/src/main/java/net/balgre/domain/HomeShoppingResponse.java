package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class HomeShoppingResponse {
	
	private HomeShopping hshop; // (HomeShopping, optional): 현재 방송정보 - 없을 경우 null ,
	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
	private List<HomeShopping> nextHShop; // (Array[HomeShopping], optional): 다음 방송정보 리스트 ,
	private List<HomeShopping> prevHShop; // (Array[HomeShopping], optional): 이전 방송정보 리스트 ,
	private String resultCode; // (string, optional): 200 성공 99 업데이트 필요 = ['200', '99', '10'],
	private String timestamp; // (string, optional)

}
