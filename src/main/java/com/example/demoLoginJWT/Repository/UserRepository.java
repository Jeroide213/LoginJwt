package com.example.demoLoginJWT.Repository;

import com.example.demoLoginJWT.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByDni(Long dni);
    User findByUsername(String username);
    User findByEmail(String email);
}