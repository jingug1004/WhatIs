package net.balgre.service;

import net.balgre.domain.UserResponse;

public interface MemberLeaveService {
	
	public UserResponse memberLeave2(String token, String reason);

}
