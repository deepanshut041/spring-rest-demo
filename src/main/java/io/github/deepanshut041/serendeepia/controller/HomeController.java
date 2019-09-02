package io.github.deepanshut041.serendeepia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("")
@Controller
public class HomeController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
