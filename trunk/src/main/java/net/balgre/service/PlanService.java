package net.balgre.service;

import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;

public interface PlanService {

	/*plan list by minho*/
    public PagePlan planList2(int page);
    
    /*plan detail by minho*/
    public Plan planDetail2(long pid);

}
