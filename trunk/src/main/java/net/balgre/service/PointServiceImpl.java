package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.PointResponse;
import net.balgre.network.PointRetroImpl;

@Service
public class PointServiceImpl implements PointService {

	@Override
	public PointResponse myPoint2(String token, int page) {
		// TODO Auto-generated method stub
		
		PointRetroImpl PRI = new PointRetroImpl();
		
		PointResponse res = PRI.myPoint2(token, page);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

}
