/**
 * Created by user on 2017-05-01 오후 8:37
 * Prac / net.balgre.service
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author 숨 크리에이티브 김진국
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/21  김진국          최초 생성
 *  </pre>
 * @since 2017/04/11
 */


package net.balgre.service;

import net.balgre.domain.AppBasketResponse;

/**
 * Created by user on 2017-05-01 오후 8:37
 * Prac / net.balgre.service
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author  숨 크리에이티브 개발팀 김진국
 * @since   2017/04/10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/05/01  김진국          최초 생성
 *  2017/06/30    정호성          전체 수정			
 * </pre>
 */

public interface BasketService {

    public AppBasketResponse basketList(String token) throws Exception;

    public AppBasketResponse basketAdd(String token, Long itemId, Long itemCount) throws Exception;

    public AppBasketResponse basketDelete(String token, Long basket_id[]) throws Exception;
    public AppBasketResponse basketUpdate(String token, Long basket_id, int item_count) throws Exception;
    public AppBasketResponse basketUpdateCheck(String token, Long basket_id[], int checked) throws Exception;
    public AppBasketResponse basketUpdateCheckAll(String token,int checked) throws Exception;

}
