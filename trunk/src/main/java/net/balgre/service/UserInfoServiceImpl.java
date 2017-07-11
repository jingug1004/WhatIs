package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.UserResponse;
import net.balgre.network.UserInfoRetroImpl;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	
	/*user info by minho*/
	@Override
	public UserResponse getUserInfo2(String token) {
		// TODO Auto-generated method stub
		
		UserInfoRetroImpl UIRI = new UserInfoRetroImpl();
		
		UserResponse res = UIRI.getUserInfo2(token);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}
	
}

