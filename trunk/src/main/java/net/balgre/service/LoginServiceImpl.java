package net.balgre.service;

import net.balgre.domain.User;
import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import net.balgre.network.LoginRetroImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public LoginDTO02 login(LoginDTO adto) throws Exception {
        LoginRetroImpl loginRetroImpl = new LoginRetroImpl();


        LoginDTO02 loginDTO02 = loginRetroImpl.getUserDetail(adto);

        return loginDTO02;
    }

    @Override
    public void keepLogin(String uid, String sessionId, Date next) throws Exception {

    }

    @Override
    public User checkLoginBefore(String value) {
        return null;
    }
}