package hodei.secretclub.controllers;

import hodei.secretclub.models.Post;
import hodei.secretclub.models.User;
import hodei.secretclub.repositories.PostRepository;
import hodei.secretclub.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 23:31
 * Project: secretClub
 * Copyright: MIT
 */
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value={"/","/login"},method= RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }
    //need to do a get request to get values, and then post it!!!!
    @PostMapping("/postpost")
    public ModelAndView postPost(@ModelAttribute(value="post") @Valid Post post){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User user =userService.findUserByUserName(auth.getName());
        ModelAndView mv=new ModelAndView();
        post.setUser(user);
       mv.addObject("post",post);
        postRepository.save(post);
        mv.setViewName("member/home");

        return mv;

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
        //create a post so user can post a post
        Post post=new Post();

        ModelAndView modelAndView=new ModelAndView();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User user =userService.findUserByUserName(auth.getName());

        //get all the posts
        List<Post> postList= postRepository.findAll();
        //set the post in the form
        modelAndView.addObject("postList",postList);
        modelAndView.addObject("post",post);

        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "\n"+ " we know you are " + user.getName() + " and your email is " + user.getEmail());
        modelAndView.addObject("adminMessage","Only the members can be here");
        modelAndView.setViewName("member/home");
        return modelAndView;
    }
}
