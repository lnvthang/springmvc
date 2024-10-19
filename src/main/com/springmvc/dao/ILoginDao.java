package com.springmvc.dao;

public interface ILoginDao {
    boolean checkUsernameAndPassword(String username, String password);
}
