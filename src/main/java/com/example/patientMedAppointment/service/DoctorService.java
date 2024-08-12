package com.example.patientMedAppointment.service;

import com.example.patientMedAppointment.dto.DoctorDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Doctor;

import java.util.List;

public interface DoctorService {

    DoctorDto save(DoctorDto doctorDto);

    List<Doctor> getAllDoctor();

}
