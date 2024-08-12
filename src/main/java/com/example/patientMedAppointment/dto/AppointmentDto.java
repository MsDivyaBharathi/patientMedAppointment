package com.example.patientMedAppointment.dto;

import com.example.patientMedAppointment.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private String id;

    private String starttime;

    private String endtime;

    private String appointmentdate;

    private String doctorname;

    private String patientName;

    private String patientPhoneNumber;

    //private PatientDto patientDto;
}
