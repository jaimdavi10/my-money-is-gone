package com.mymoneyisgone.security;

import com.mymoneyisgone.data.UserRepository;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserRepository ur;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository ur, PasswordEncoder passwordEncoder) {

        this.ur = ur;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) throws Exception {
        /*User user = new User("foo@foo.com", "foo", passwordEncoder.encode("password"),
                "John", "Adams");
        user.setRoles(Set.of(User.Role.ROLE_ADMIN));
        user.setEnabled(true);
        ur.save(user);

        User user1 = new User("foo1@foo.com", "foo1", passwordEncoder.encode("password"),
                "Abigail", "Adams");
        user1.setRoles(Set.of(User.Role.ROLE_USER));
        user1.setEnabled(true);
        ur.save(user1);*/
    }

}
