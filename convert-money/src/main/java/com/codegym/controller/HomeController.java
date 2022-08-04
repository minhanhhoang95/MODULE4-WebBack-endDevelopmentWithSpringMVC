package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("WEB-INF/views/home.jsp");

        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView showInfo(@RequestParam String convert) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("WEB-INF/views/info.jsp");
        modelAndView.addObject("convert", convert);
        int result = Integer.parseInt(convert) * 24000 ;
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
