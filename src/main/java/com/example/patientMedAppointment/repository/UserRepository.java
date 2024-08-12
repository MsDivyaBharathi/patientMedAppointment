package com.example.patientMedAppointment.repository;

import com.example.patientMedAppointment.entity.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<AuthUser, String> {

    //select * from user where username = value or email = value
    //Optional<User> findByUsernameOrEmail(String username, String email);

     Optional<AuthUser> findByUsername(String username);
}
