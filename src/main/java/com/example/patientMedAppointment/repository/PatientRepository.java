package com.example.patientMedAppointment.repository;

import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,String> {

    PatientDto findByphoneNumber(String phoneNumber);
}
