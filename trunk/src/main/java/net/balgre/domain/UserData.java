package net.balgre.domain;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class UserData {
//	  "id": 389499473,
//    "kaccount_email: ddddd@ddddd.com,
//	  "properties": {
//	    "profile_image": "",
//	    "nickname": "숨크리에티브",
//	    "thumbnail_image": ""
//	  }
	
	
	@SerializedName("id")
	String id;

	public String getId() {
		return id;
	}
	
	@SerializedName("kaccount_email")
	String mail;
	
	public String getMail() {
		return mail;
	}
	
	@SerializedName("properties")
	@Getter @Setter
	UserDataProperties properties;
	
}
