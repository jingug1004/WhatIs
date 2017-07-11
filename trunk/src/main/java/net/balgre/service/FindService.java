package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.UserResponse;

public interface FindService {
	
	/*find id*/
	public UserResponse findId2(String name, String phone);
	
	/*find password email*/
	public CommonResponse findPwEmail2(String email, String name);
	
	/*find password phone*/
	public CommonResponse findPwPhone2(String email, String phone);

}
