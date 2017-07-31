package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class NaverPayOption {
	
	private int optionQuantity;
	private int optionPrice; 
	private String selectionCode;
	private List<NaverPayOptionSelections> selections ;
}
