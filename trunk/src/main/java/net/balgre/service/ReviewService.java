package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.MyReviewResponse;
import net.balgre.domain.PageReview;

public interface ReviewService {

    public CommonResponse reviewInsert2();
    
    public MyReviewResponse possibleReview2(String token);
    
    public PageReview reviewList2(int page, long product_id, int photo, int sort);


}





