package com.springmvc.controller;

import com.springmvc.facade.ILoginFacade;
import com.springmvc.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @Autowired
    private ILoginFacade loginFacade;

    @Autowired
    private Util util;

    @GetMapping("/login")
    public ModelAndView getPage() {
        return util.setPage("login");
    }

    @PostMapping("/login")
    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password) {
        ModelAndView mav = new ModelAndView("login");
        boolean isUser = loginFacade.CheckUsernameAndPassword(username, password);
        if (isUser) {
            mav.setViewName("home");
        } else {
            mav.setViewName("login");
            mav.addObject("errorMessage", "Username or password is incorrect");
        }
        return mav;
    }

}
