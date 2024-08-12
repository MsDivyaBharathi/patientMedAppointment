package com.example.patientMedAppointment.service;

import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRegService {

    PatientDto save(PatientDto patientDto);

    PatientDto getPatientDetail(String phoneNumber);

    List<Patient> getpatient();

    void deletepatient(String id);

    Patient updatePatient(Patient patient);

    Optional<Patient> findPatientById(String id);
}
