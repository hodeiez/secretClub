package hodei.secretclub.controllers;

import hodei.secretclub.models.User;
import hodei.secretclub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
