package hodei.secretclub.services;

import hodei.secretclub.models.Role;
import hodei.secretclub.models.User;
import hodei.secretclub.repositories.RoleRepository;
import hodei.secretclub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:35
 * Project: secretClub
 * Copyright: MIT
 */
@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    public User saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole=roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}
