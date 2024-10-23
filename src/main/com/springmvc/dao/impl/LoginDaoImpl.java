package main.com.springmvc.dao.impl;

import com.springmvc.dao.ILoginDao;

public class LoginDaoImpl implements ILoginDao {

    private static final String CHECK_USERNAME_AND_PASSWORD = "123456789";

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        return username.equals("admin") && password.equals("1");
    }
}
