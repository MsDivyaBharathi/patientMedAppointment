package com.example.patientMedAppointment.repository;

import com.example.patientMedAppointment.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor,String> {

}
