package hodei.secretclub.controllers;

import hodei.secretclub.models.Post;
import hodei.secretclub.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Hodei Eceiza
 * Date: 4/25/2021
 * Time: 23:08
 * Project: secretClub
 * Copyright: MIT
 */
@Controller
public class PublicController {
    @Autowired
    PostRepository postRepository;

    @RequestMapping(value={"/"},method= RequestMethod.GET)
    public ModelAndView publicHome(){
        Post mostCommented=getPostMostCommented();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("publicHome");
        modelAndView.addObject("mostcommented",mostCommented);
        return modelAndView;
//checkin errors
    }

    public Post getPostMostCommented(){
        List<Post> postList=postRepository.findAll();
        Post post=postList.stream().max(Comparator.comparingInt(p->p.getMessage().size())).get();
        return post;
    }
}
