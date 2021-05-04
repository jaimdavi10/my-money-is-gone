package com.mymoneyisgone.security;

import com.mymoneyisgone.data.UserRepository;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository ur;

    @Autowired
    public UserDetailsServiceImpl(UserRepository ur){
        this.ur = ur;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{


        //User user = ur.findByUsername(username);
        User user = ur.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("Email" + email + "not found");
        return user;
    }


}
