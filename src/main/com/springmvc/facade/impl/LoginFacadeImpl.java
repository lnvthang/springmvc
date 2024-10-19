package com.springmvc.facade.impl;

import com.springmvc.facade.ILoginFacade;
import com.springmvc.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginFacadeImpl implements ILoginFacade {

    @Autowired
    private ILoginService loginService;

    @Override
    public boolean CheckUsernameAndPassword(String username, String password) {
        return loginService.checkUsernameAndPassword(username, password);
    }
}
