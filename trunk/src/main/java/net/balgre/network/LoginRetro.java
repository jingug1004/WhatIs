/**
 * Created by user on 2017-04-17 오후 12:43
 * Prac / net.balgre.network
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


package net.balgre.network;

import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by user on 2017-04-17 오후 12:43
 * Prac / net.balgre.network
 * No pain, No gain!
 * What :
 * Why :
 * How :
 *
 * @author  숨 크리에이티브 개발팀 김진국
 * @version 1.0
 * @since   2017/04/10
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2017/04/21  김진국          최초 생성
 *  </pre>
 *
 */


public interface LoginRetro {
//
//    @GET("/api/auth/login")
//    Call<UserResponse> getUserResponse();

//    @FormUrlEncoded
    @POST("/api/auth/login")
    @Headers({
            "X-Requested-With:XMLHttpRequest",
            "Content-Type:application/json"
    })
    Call<LoginDTO02> getUserLogin(
            @Body LoginDTO loginDTO
    );

}
