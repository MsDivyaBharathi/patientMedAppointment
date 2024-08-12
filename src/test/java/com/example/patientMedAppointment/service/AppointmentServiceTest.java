package com.example.patientMedAppointment.service;

import com.example.patientMedAppointment.dto.AppointmentDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.repository.AppointmentRepository;
import com.example.patientMedAppointment.service.impl.AppointmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    //private ModelMapper modelMapper;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    private Appointment appointment;
    private AppointmentDto appointmentDto;

    @BeforeEach
    public  void setUp()
    {
         appointment = new Appointment("1","10:00","12:00","05-08-2024","john","karthick","9512345679");
         appointmentDto = new AppointmentDto("1","10:00","12:00","05-08-2024","john","karthick","9512345679");
    }

    @Test
    public void testGivenApointmentObj_whenSaveAppointment_thenReturnSavedAppointmentObject()
    {
        BDDMockito.given(appointmentRepository.save(appointment)).willReturn(appointment);
        AppointmentDto savedAppointment = appointmentService.create(appointmentDto);
        assertThat(savedAppointment).isNotNull();
    }

}
