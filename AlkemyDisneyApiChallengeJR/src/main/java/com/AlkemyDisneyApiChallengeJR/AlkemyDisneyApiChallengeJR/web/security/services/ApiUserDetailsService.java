package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.security.services;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.UserRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.ApiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApiUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApiUser> user = userRepository.findByUsername(username);
        Set<GrantedAuthority> auths = new HashSet<>();

        User userDetail = new
                User(user.get().getUsername(),
                "{noop}" + user.get().getPassword(),
                true, true, true,true,
                auths);



        return userDetail;
    }

}
