package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.User;
import net.balgre.domain.UserResponse;

public interface UserJoinService {


    public UserResponse userJoin1(User user);

    public CommonResponse phone_check(String phone);

    public CommonResponse phone_check2(String phone, String cert);


}
