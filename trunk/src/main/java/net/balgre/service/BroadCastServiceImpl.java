package net.balgre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.balgre.domain.HomeShopping;
import net.balgre.domain.HomeShoppingResponse;
import net.balgre.network.BroadCastRetroImpl;

@Service
public class BroadCastServiceImpl implements BroadCastService {
	
	
	/*방송 편성표*/
	@Override
	public List<HomeShopping> broadCastSchedule2(String date) {
		// TODO Auto-generated method stub
		
		BroadCastRetroImpl BCRI = new BroadCastRetroImpl();
		List<HomeShopping> res = BCRI.broadCastSchedule(date);
		
		if (res == null) {
			
			return null;
		} else
			
			return res;
	}
	
	
	/*방송 있는 날*/
	@Override
	public List<Integer> broadDate() {
		// TODO Auto-generated method stub
		
		BroadCastRetroImpl BCRI = new BroadCastRetroImpl();
		List<Integer> res = BCRI.broadDate();
		
		if (res == null) {
			
			return null;
		} else {
			
			return res;
		}
	}

	
	/*현재 방송 정보*/
	@Override
	public HomeShoppingResponse broadCastInformation2() {
		// TODO Auto-generated method stub
		
		BroadCastRetroImpl BCRI = new BroadCastRetroImpl();
		HomeShoppingResponse res = BCRI.broadCastInformation();
		
		if (res == null) {
			
			return null;
		} else {
			
			return res;
		}
	}

}
