package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.UserResponse;
import net.balgre.network.MemberLeaveRetroImpl;

@Service
public class MemberLeaveServiceImpl implements MemberLeaveService {

	/*member leave*/
	@Override
	public UserResponse memberLeave2(String token, String reason) {
		// TODO Auto-generated method stub
		
		MemberLeaveRetroImpl MLRI = new MemberLeaveRetroImpl();
		
		UserResponse res = MLRI.memberLeave(token, reason);
		
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
