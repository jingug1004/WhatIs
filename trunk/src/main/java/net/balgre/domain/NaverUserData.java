package net.balgre.domain;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class NaverUserData {
//	  "email": "ohakuma@naver.com",
//	    "nickname": "oha****",
//	    "enc_id": "dd46bf3a4e6d810b57a7c4b25e5b43cadee72b7c888acebbff9764910caa45fa",
//	    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//	    "age": "30-39",
//	    "gender": "M",
//	    "id": "18278565",
//	    "name": "정호성",
//	    "birthday": "02-06"
	

	@SerializedName("id")
	@Getter @Setter
	String id;
	
	@SerializedName("email")
	@Getter @Setter
	String email;
	
	@SerializedName("name")
	@Getter @Setter
	String name;
	
}
