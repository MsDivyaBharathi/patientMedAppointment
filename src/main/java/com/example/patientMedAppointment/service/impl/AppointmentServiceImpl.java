package com.example.patientMedAppointment.service.impl;

import com.example.patientMedAppointment.dto.AppointmentDto;
import com.example.patientMedAppointment.dto.DoctorDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Doctor;
import com.example.patientMedAppointment.repository.AppointmentRepository;
import com.example.patientMedAppointment.repository.PatientRepository;
import com.example.patientMedAppointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService
{
    private AppointmentRepository appointmentRepository;

    private ModelMapper modelMapper;
    @Override
    public AppointmentDto create(AppointmentDto appointmentDto) {

        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);

            return modelMapper.map(appointmentRepository.save(appointment), AppointmentDto.class);
    }

    public List<Appointment> getappointment(){
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointById(String id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Optional<Appointment> findAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
