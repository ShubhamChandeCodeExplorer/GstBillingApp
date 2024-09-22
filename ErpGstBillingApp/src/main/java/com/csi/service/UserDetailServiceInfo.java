package com.csi.service;

import com.csi.enitity.UserData;
import com.csi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class UserDetailServiceInfo implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserData saveUser(UserData user){
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData user=userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),new ArrayList<>());
    }
}
