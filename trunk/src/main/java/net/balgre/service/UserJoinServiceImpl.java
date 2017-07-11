package net.balgre.service;

import org.springframework.stereotype.Service;

import net.balgre.controller.QnaController;
import net.balgre.domain.CommonResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;
import net.balgre.network.UserJoinRetroImpl;

@Service
public class UserJoinServiceImpl implements UserJoinService {

    // UserJoinService 참조하는 UserJoinService 구현체

    @Override
    // 재정의
    public UserResponse userJoin1(User user) {
        // 해당 메서드는 service interface의 재정의 메서드이며 파라미터로 user값을 받는다.
    	
        UserJoinRetroImpl userJRI = new UserJoinRetroImpl();
        // retroImpl 인스턴스 생성

        UserResponse res = userJRI.userJoin2(user);
        // 생성한 인스턴스의 userJoint2 메서드를 호출하며 user값을 파라미터로 넘겨준다.
        // 그리고 리턴 받은 값을 UserResponse res 에 대입한다.

        if(res == null) {
            return null;
        }

        if( res.getResultCode().equals("200")) {
            return res;
        } else {
            return null;
        }
    }

    @Override
    public CommonResponse phone_check(String phone) {
        UserJoinRetroImpl userJRI = new UserJoinRetroImpl();
        CommonResponse com = userJRI.phone_check(phone);

        return com;
    }

    @Override
    public CommonResponse phone_check2(String phone, String cert) {
        UserJoinRetroImpl userJRI = new UserJoinRetroImpl();
        CommonResponse com2 = userJRI.phone_check2(phone, cert);

        return com2;
    }




}