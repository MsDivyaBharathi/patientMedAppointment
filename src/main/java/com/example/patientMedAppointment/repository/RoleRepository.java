package com.example.patientMedAppointment.repository;

import com.example.patientMedAppointment.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
