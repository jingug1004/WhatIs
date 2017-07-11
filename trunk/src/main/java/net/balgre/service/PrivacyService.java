package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;

public interface PrivacyService {
	
	public UserResponse privacy2(String token);
	
	/*privacy update*/
	public UserResponse privacyUpdate2(String password, Integer skin, String smsagree, 
			String emailagree, String token);
	
	/*privacy sns connect*/
	public CommonResponse privacySnsCon2(String sns_id, String sns_type, String token);
	
	/*privacy sns disConnect*/
	public CommonResponse privacySnsDisCon2(String sns_type, String token);

}
