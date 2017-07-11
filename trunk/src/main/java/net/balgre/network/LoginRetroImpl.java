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

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017-04-17 오후 12:43
 * Prac / net.balgre.network
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


public class LoginRetroImpl {
    private LoginRetro loginRetro = null;

    public LoginRetroImpl() {
        this.loginRetro = this.create();
    }

//    public UserResponse getUserResponse() {
//        Call<UserResponse> call = this.loginRetro.getUserResponse();
//        try {
//            Response<UserResponse> response = call.execute();
//            if (response.isSuccessful()) {
//                System.out.println(response.body().getResultCode());
//                return response.body();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public LoginDTO02 getUserDetail(LoginDTO loginDTO) {
        Call<LoginDTO02> call = this.loginRetro.getUserLogin(loginDTO);
        try {
            Response<LoginDTO02> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected LoginRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(LoginRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}