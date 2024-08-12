package com.example.patientMedAppointment.repository;
import com.example.patientMedAppointment.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {
}
