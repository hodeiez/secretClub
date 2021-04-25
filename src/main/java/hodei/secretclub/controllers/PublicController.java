package hodei.secretclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Hodei Eceiza
 * Date: 4/25/2021
 * Time: 23:08
 * Project: secretClub
 * Copyright: MIT
 */
@Controller
public class PublicController {
    @RequestMapping(value={"/"},method= RequestMethod.GET)
    public ModelAndView publicHome(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("publicHome");
        return modelAndView;

    }
}
