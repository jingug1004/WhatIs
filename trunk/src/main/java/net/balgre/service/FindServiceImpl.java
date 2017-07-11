package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;
import net.balgre.network.FindRetroImpl;

@Service
public class FindServiceImpl implements FindService {

	/*find id*/
	@Override
	public UserResponse findId2(String name, String phone) {
		// TODO Auto-generated method stub
		
		FindRetroImpl FRI = new FindRetroImpl();
		
		UserResponse res = FRI.findId2(name, phone);
		
		if (res == null) {
			
			return null;
		} 
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

	
	/*find password email*/
	@Override
	public CommonResponse findPwEmail2(String email, String name) {
		// TODO Auto-generated method stub
		
		FindRetroImpl FRI = new FindRetroImpl();
		
		CommonResponse res = FRI.findPwEmail2(email, name);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}


	/*find password phone*/
	@Override
	public CommonResponse findPwPhone2(String email, String phone) {
		// TODO Auto-generated method stub
		
		FindRetroImpl FRI = new FindRetroImpl();
		
		CommonResponse res = FRI.findPwPhone2(email, phone);
		
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
