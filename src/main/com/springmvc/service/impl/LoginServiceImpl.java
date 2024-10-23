package main.com.springmvc.service.impl;

import com.springmvc.dao.ILoginDao;
import com.springmvc.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginDao loginDao;

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        return loginDao.checkUsernameAndPassword(username, password);
    }
}
