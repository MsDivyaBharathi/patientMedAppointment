package com.example.patientMedAppointment.service;

import com.example.patientMedAppointment.dto.AppointmentDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    AppointmentDto create(AppointmentDto appointmentDto);

    List<Appointment> getappointment();


    void deleteAppointById(String id);

    Optional<Appointment> findAppointmentById(String id);

    Appointment updateAppointment(Appointment appointment);
}
