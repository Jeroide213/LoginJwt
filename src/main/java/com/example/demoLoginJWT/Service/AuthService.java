package com.example.demoLoginJWT.Service;

import com.example.demoLoginJWT.Models.User;
import com.example.demoLoginJWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    public Optional<User>findByDni(Long dni){
        return userRepository.findByDni(dni);
    }
}
