package com.example.mamnoncvn.login.service;

import com.example.mamnoncvn.accountManager.accountPH.service.PhuHuynhAccountService;
import com.example.mamnoncvn.login.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    PhuHuynhAccountService phuHuynhAccountService;

    public boolean isLoginSuccess(LoginRequest loginRequest){
        if (phuHuynhAccountService.haveUsername(loginRequest.getUsername()) &&
        phuHuynhAccountService.havePassword(loginRequest.getPassword())){
            return true;
        } else if (loginRequest.getUsername().equals("admin") &&
                loginRequest.getPassword().equals("admin")){
            return true;
        } else return false;
    }
}
