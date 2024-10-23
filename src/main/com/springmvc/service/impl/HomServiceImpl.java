package main.com.springmvc.service.impl;

import main.com.springmvc.dao.IHomeDao;
import main.com.springmvc.model.UserModel;
import main.com.springmvc.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomServiceImpl  implements IHomeService {

    @Autowired
    public IHomeDao homeDao;

    @Override
    public List<UserModel> getListUser() {
        return homeDao.getListUser();
    }
}
