package net.balgre.service;

import net.balgre.domain.CommonResponse;
import net.balgre.domain.MainResponse;
import net.balgre.domain.Product;


public interface MainService {

    public MainResponse showMain() throws Exception;

//    public String login(UserService user) throws Exception;

    public void id(Product product) throws Exception;
    public CommonResponse sendSms(String phone) throws Exception;
    

}
