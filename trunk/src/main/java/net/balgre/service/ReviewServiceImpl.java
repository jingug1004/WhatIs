package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.MyReviewResponse;
import net.balgre.domain.PageReview;
import net.balgre.network.ReviewRetroImpl;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Override
	public CommonResponse reviewInsert2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyReviewResponse possibleReview2(String token) {
		// TODO Auto-generated method stub
		
		ReviewRetroImpl RRI = new ReviewRetroImpl();
		
		MyReviewResponse res = RRI.possibleReview(token);
		
		if (res == null) {
			
			return null;
		}
		if (res.getResultCode().equals("200")) {
			
			return res;
		} else {
			
			return null;
		}
	}

	@Override
	public PageReview reviewList2(int page, long product_id, int photo, int sort) {
		// TODO Auto-generated method stub
		
		ReviewRetroImpl RRI = new ReviewRetroImpl();
		
		PageReview res = RRI.reviewList2(page, product_id, photo, sort);
		
		return res;
	}
}