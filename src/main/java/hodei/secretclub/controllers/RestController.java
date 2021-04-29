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

import java.util.List;

/**
 * Created by Hodei Eceiza
 * Date: 4/29/2021
 * Time: 12:37
 * Project: secretClub
 * Copyright: MIT
 */
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/access")
public class RestController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping("")
    @ResponseBody
    public List<Post> getAllUsers(){
        return postRepository.findAll();
    }
}
