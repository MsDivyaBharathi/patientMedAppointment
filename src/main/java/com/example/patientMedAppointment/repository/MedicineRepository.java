package com.example.patientMedAppointment.repository;

import com.example.patientMedAppointment.entity.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicineRepository extends MongoRepository<Medicine,String> {
}
