/**
 * Created by user on 2017-04-17 오후 5:26
 * Prac / net.balgre.dto
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

package net.balgre.dto;

import lombok.Setter;
import net.balgre.BalgreConstants;

/**
 * Created by user on 2017-04-17 오후 5:26
 * Prac / net.balgre.dto
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
 *  2017/04/21  김진국          최초 생성 
 *  </pre>
 */

public class LoginDTO02 {

	@Setter 
    private String token;
	
	@Setter
    private String refreshToken;

	public String getToken() {
		return BalgreConstants.TOKEN_SUFFIX + token;
	}

	public String getRefreshToken() {
		return BalgreConstants.TOKEN_SUFFIX + refreshToken;
	}

	
	
}