package net.balgre.network;

import java.util.List;

import lombok.Data;
import net.balgre.domain.CategoryLvResult;

@Data
public class PageCategory {
	
	private List<CategoryLvResult> content;
	private String resultCode;
	private String timestamp;
	private String message;

}
