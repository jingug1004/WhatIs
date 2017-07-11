/**
 * Created by user on 2017-04-11 오전 11:24
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.balgre.domain.Brand;
import net.balgre.domain.CategoryLvResult;
import net.balgre.domain.CategoryResponse;
import net.balgre.domain.CommonResponse;
import net.balgre.domain.MainResponse;
import net.balgre.domain.Product;
import net.balgre.network.BalgreClient;
import net.balgre.network.MainRetroImpl;

/**
 * Created by user on 2017-04-11 오전 11:24
 * Prac / net.balgre.service
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author  숨 크리에이티브 김진국
 * @since   2017/04/11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/11  김진국          최초 생성
 *  </pre>
 */

@Service
public class MainServiceImpl implements MainService {

//    BalgreClient client;

//    @Before
//    public void setup() {0
//        client = new BalgreClient();
//    }

    @Override
    public MainResponse showMain() throws Exception {

        MainRetroImpl client = new MainRetroImpl();

        MainResponse mainResponse = client.getMain();

        return mainResponse;
    }

    @Override
    public void id(Product product) throws Exception {
        Long productId = 1L;
//        Product response = client.getProductDetail(productId);
    }

	@Override
	public CommonResponse sendSms(String phone) throws Exception {
		BalgreClient client = new BalgreClient();
		return client.appDown(phone);
	}

	
}