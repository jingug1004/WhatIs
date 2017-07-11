package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.PagePlan;
import net.balgre.domain.Plan;
import net.balgre.network.PlanRetroImpl;

@Service
public class PlanServiceImpl implements PlanService {

	/*plan list by minho*/
	@Override
	public PagePlan planList2(int page) {
		// TODO Auto-generated method stub
		
		PlanRetroImpl PRI = new PlanRetroImpl();
		
		PagePlan res = PRI.planList2(page);
		
		return res;

   }

	@Override
	public Plan planDetail2(long pid) {
		// TODO Auto-generated method stub
		
		PlanRetroImpl PRI = new PlanRetroImpl();
		
		Plan res = PRI.planDetail2(pid);
		
		return res;
	}
}