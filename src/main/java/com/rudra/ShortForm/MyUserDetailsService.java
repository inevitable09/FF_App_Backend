package com.rudra.ShortForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel u = dao.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(
                u.getUsername(),
                u.getPassword(),
                List.of(new SimpleGrantedAuthority(u.getRole()))
        );
    }
}