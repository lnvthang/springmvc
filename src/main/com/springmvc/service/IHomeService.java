package main.com.springmvc.service;

import main.com.springmvc.model.UserModel;

import java.util.List;

public interface IHomeService {
    List<UserModel> getListUser();
}
