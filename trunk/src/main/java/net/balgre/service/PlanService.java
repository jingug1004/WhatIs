package net.balgre.service;

import java.util.List;

import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;

public interface PlanService {

	/*plan list by minho*/
    public List<Plan> planList2();
    
    /*plan detail by minho*/
    public Plan planDetail2(long pid);

}
