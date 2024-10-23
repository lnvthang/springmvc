package main.com.springmvc.facade;

import java.util.List;
import main.com.springmvc.model.UserModel;

public interface IHomeFacade {
    List<UserModel> getAllUser();
}
