package net.balgre.domain;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class UserDataProperties {
	
//	  "properties": {
//    "profile_image": "",
//    "nickname": "숨크리에티브",
//    "thumbnail_image": "",
//  }
	
	@SerializedName("nickname")
	@Getter @Setter
	String nickname;

}
