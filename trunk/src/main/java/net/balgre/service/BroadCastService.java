package net.balgre.service;

import java.util.List;

import net.balgre.domain.HomeShopping;
import net.balgre.domain.HomeShoppingResponse;

public interface BroadCastService {
	
	/*방송 편성표*/
	public List<HomeShopping> broadCastSchedule2(String date);
	
	/*방송 있는 날*/
	public List<Integer> broadDate();
	
	/*현재 방송 정보*/
	public HomeShoppingResponse broadCastInformation2();

}
