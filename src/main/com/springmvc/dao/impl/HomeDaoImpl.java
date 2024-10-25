package main.com.springmvc.dao.impl;

import main.com.springmvc.dao.IHomeDao;
import main.com.springmvc.model.UserModel;
import main.com.springmvc.util.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeDaoImpl implements IHomeDao {

    private static final String GET_USER_LIST = "SELECT * FROM tbl_account";
    private static final String GET_USER_BY_SEARCH = GET_USER_LIST + " WHERE tbl_account.name = ?";

    @Autowired
    private Query query;

    @Override
    public List<UserModel> getListUser() {
        return query.executeQueryList(GET_USER_LIST, null, UserModel.class);
    }

    @Override
    public UserModel getUserBySearch() {
        Map<Integer, String> parameters = new HashMap<>();
        parameters.put(1, "admin");
        return query.executeQueryObject(GET_USER_BY_SEARCH, parameters, UserModel.class);
    }
}
