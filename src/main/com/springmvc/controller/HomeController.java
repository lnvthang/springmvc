package com.springmvc.controller;

import com.springmvc.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private Util util;

    @RequestMapping("/home")
    public ModelAndView getPage() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "Hello, World!"); // Add this line
        return mav;
    }

}
