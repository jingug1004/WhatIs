package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class PlanGroup {
	
	private int pgId; // (integer, optional): 기획전 그룹 ID ,
	private List<PlanProduct> planProduct; // (Array[PlanProduct], optional): 기획전 상품 목록 ,
	//private int sort; // (integer, optional): 순서 ,
	private int stopGroup; // (integer, optional): 진행여부 0 : 진행중 1 : 종료 ,
	private String thumbnail; // (string, optional): 썸네일

}
