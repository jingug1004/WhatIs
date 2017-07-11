package net.balgre.service;

import net.balgre.domain.User;
import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;

import java.util.Date;


public interface LoginService {

    public LoginDTO02 login(LoginDTO dto) throws Exception;

    public void keepLogin(String uid, String sessionId, Date next) throws Exception;

    public User checkLoginBefore(String value);


}
