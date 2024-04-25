package com.example.demoLoginJWT.Service;

import com.example.demoLoginJWT.Models.User;
import com.example.demoLoginJWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        return userRepository.save(newUser);
    }
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
}
