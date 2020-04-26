package com.example.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import com.example.entities.s_mst_user_entity;
import com.example.model.UserCustomDetails;
import com.example.service.UserService;


@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private UserService userRepository;

    public UserDetailsImpl() {
        super();
    }

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserService.class);
    }

    @Override
    public UserDetails loadUserByUsername( String username) {
    	s_mst_user_entity appUser = userRepository.findByStaffcd(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return  UserCustomDetails.create(appUser);
    }
    
   
}
