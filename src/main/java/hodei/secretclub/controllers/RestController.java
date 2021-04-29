package hodei.secretclub.controllers;

import hodei.secretclub.models.Post;
import hodei.secretclub.models.User;
import hodei.secretclub.repositories.PostRepository;
import hodei.secretclub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hodei Eceiza
 * Date: 4/29/2021
 * Time: 12:37
 * Project: secretClub
 * Copyright: MIT
 */
//@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/access")
public class RestController {
    @Autowired
    PostRepository postRepository;
    @GetMapping("")
    @ResponseBody
    public Post getPostMostCommented(){
        List<Post> postList=postRepository.findAll();
      Post post=postList.stream().max(Comparator.comparingInt(p->p.getMessage().size())).get();
        return post;
    }
}
