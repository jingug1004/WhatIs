package net.balgre.domain;

import java.util.List;

import lombok.Data;

@Data
public class Plan {
	
	private int pid; // (integer, optional): 기획전 ID ,
	private List<PlanGroup> planGroup; // (Array[PlanGroup], optional): 기획전 그룹 ,
	private String regDate; // (string, optional): 등록일 ,
	//private int sort; // (integer, optional): 순서 ,
	private int stopPlan; // (integer, optional): 진행여부 0 : 진행중 1 : 종료 ,
	private String thumbnail; // (string, optional): 썸네일 ,
	private String title; // (string, optional): 제목

}
