package com.springmvc.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Util {
    public ModelAndView setPage(String page) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(page);
        return mv;
    }
}
