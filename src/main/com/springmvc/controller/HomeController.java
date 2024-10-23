package main.com.springmvc.controller;

import main.com.springmvc.facade.IHomeFacade;
import com.springmvc.util.Util;
import main.com.springmvc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private Util util;

    @Autowired
    private IHomeFacade homeFacade;

    @RequestMapping("/home")
    public ModelAndView getPage() {
        ModelAndView mav = new ModelAndView("home");
        List<UserModel> userList = homeFacade.getAllUser();
        if (userList != null) {
            mav.addObject("userList", userList);
        }
        mav.addObject("message", "Hello, World!"); // Add this line
        return mav;
    }

}
