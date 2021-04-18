package hodei.secretclub.controllers;

import hodei.secretclub.models.User;
import hodei.secretclub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 23:31
 * Project: secretClub
 * Copyright: MIT
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/","/login"},method= RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }
    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView=new ModelAndView();
        User user=new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value="/registration",method=RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindinResult){
        ModelAndView modelAndView=new ModelAndView();
        User userExists=userService.findUserByUserName(user.getUserName());
        if(userExists !=null){
            bindinResult
                    .rejectValue("userName","error.user", "someone is registered with this user name, but its a secret");
        }
        if(bindinResult.hasErrors()){
            modelAndView.setViewName("registration");
        }
        else{
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "registered successfully");
            modelAndView.addObject("user",new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    @RequestMapping(value="/member/home",method=RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User user =userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome" + user.getUserName() + "\n"+ "we know you are " + user.getName() + " and your email is " + user.getEmail());
        modelAndView.addObject("adminMessage","Only the members can be here");
        modelAndView.setViewName("member/home");
        return modelAndView;
    }
}
