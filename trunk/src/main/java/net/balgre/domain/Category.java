package net.balgre.domain;

import lombok.Data;

@Data
public class Category {
	
	private String menuId;
	private String menuName;
	private String menuParent;
	private String menuDepth;
	private String menuVisible;

}
