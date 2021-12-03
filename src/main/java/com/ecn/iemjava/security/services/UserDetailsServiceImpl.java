package com.ecn.iemjava.security.services;

import com.ecn.iemjava.models.Access;
import com.ecn.iemjava.models.User;
import com.ecn.iemjava.repository.AccessRepository;
import com.ecn.iemjava.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository userRepository;
    AccessRepository accessRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, AccessRepository accessRepository) {
        this.userRepository = userRepository;
        this.accessRepository = accessRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = accessRepository.findUserByAccount(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
