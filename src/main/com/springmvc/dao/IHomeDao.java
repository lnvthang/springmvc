package main.com.springmvc.dao;

import main.com.springmvc.model.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface IHomeDao {

    List<UserModel> getListUser();

    UserModel getUserBySearch();
}
