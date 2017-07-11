package net.balgre.domain;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class NaverUserResponse {
	
	@SerializedName("resultcode")
	@Getter @Setter
	String resultcode;
	
	@SerializedName("message")
	@Getter @Setter
	String message;
	
	
	@SerializedName("response")
	@Getter @Setter
	NaverUserData response;

}