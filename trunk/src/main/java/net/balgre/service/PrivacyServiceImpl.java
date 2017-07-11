package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import net.balgre.network.PrivacyRetroImpl;
import net.balgre.network.UserInfoRetroImpl;

@Service
public class PrivacyServiceImpl implements PrivacyService {

	
	@Override
	public UserResponse privacy2(String token) {
		// TODO Auto-generated method stub
		
		UserInfoRetroImpl UIR = new UserInfoRetroImpl();
		
		UserResponse res = UIR.getUserInfo2(token);
		
		if (res == null) {
			return null;
		}
		
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			return null;
		}
	}


	/*privacy update*/
	@Override
	public UserResponse privacyUpdate2(String password, Integer skin, String smsagree, String emailagree, String token) {
		// TODO Auto-generated method stub
		
		PrivacyRetroImpl PRI = new PrivacyRetroImpl();
		
		UserResponse res = PRI.privacyUpdate(password, skin, smsagree, 
				emailagree, token);
		
		if (res == null) {
			return null;
		}
		
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

    
	/*privacy sns connect*/
	@Override
	public CommonResponse privacySnsCon2(String sns_id, String sns_type, String token) {
		// TODO Auto-generated method stub
		
		PrivacyRetroImpl PRI = new PrivacyRetroImpl();
		
		CommonResponse res = PRI.privacySnsCon(sns_id, sns_type, token);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

    
	/*privacy sns disConntect*/
	@Override
	public CommonResponse privacySnsDisCon2(String sns_type, String token) {
		// TODO Auto-generated method stub
		
		PrivacyRetroImpl PRI = new PrivacyRetroImpl();
		
		CommonResponse res = PRI.privacySnsDisCon(sns_type, token);
		
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
