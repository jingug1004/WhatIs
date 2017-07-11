package net.balgre.network;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.MainResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserJoinRetroImpl {
    private UserJoinRetro userJoinRetro = null;

    public UserJoinRetroImpl() {
        this.userJoinRetro = this.create();
    }


    public MainResponse getMain() {
        Call<MainResponse> call = this.userJoinRetro.getMain();
        try {
            Response<MainResponse> response = call.execute();
            if ( response.isSuccessful() ) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*user join*/
    public UserResponse userJoin2(User user) {

        // retro interface userJoin 메서드를 호출하며, user를 파라미터로 전달해줌.
        // parameter값은 domain에서 꺼내서 넘겨주는 것이기 때문에 Retro가 아닌 domain 필드명을 따라간다.
        Call<UserResponse> call = this.userJoinRetro.userJoin(user.getEmail(), user.getName(),
                user.getPassword(), user.getBirthday(), user.getPhone(), user.getJoinType(), user.getSkinType(), 
                user.getSmsAgree(), user.getEmailAgree(), user.getGender(), user.getMyCode(), 
                user.getSns_id());

        try {
            Response<UserResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*send sms*/
    public CommonResponse phone_check(String phone) {

        Call<CommonResponse> call = this.userJoinRetro.phone_check(phone);

        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*sms_cert*/
    public CommonResponse phone_check2(String phone, String cert) {

        Call<CommonResponse> call = this.userJoinRetro.phone_check2(phone, cert);

        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected UserJoinRetro create() {
    	Retrofit retrofit = RetrofitHelper.getInstance().getRetroFit();

        return retrofit.create(UserJoinRetro.class);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

}
