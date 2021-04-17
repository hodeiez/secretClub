package hodei.secretclub.services;

import hodei.secretclub.models.Role;
import hodei.secretclub.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:46
 * Project: secretClub
 * Copyright: MIT
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    // get which role is granted
    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles){
        Set<GrantedAuthority> roles=new HashSet<>();
        for(Role role :userRoles){
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities =new ArrayList<>(roles);
        return grantedAuthorities;

    }
    //builds a new User
    private UserDetails buildUserForAuthentication (User user, List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),user.getActive(),true,true,true,authorities);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userService.findUserByUserName(userName);
        List<GrantedAuthority> authorities=getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user,authorities);
    }
}
