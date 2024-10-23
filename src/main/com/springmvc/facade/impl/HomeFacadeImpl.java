package main.com.springmvc.facade.impl;

import main.com.springmvc.facade.IHomeFacade;
import main.com.springmvc.model.UserModel;
import main.com.springmvc.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomeFacadeImpl implements IHomeFacade {

    @Autowired
    public IHomeService homeService;

    @Override
    public List<UserModel> getAllUser() {
        return homeService.getListUser();
    }
}
