package com.example.patientMedAppointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private String id;

    private String doctorname;

    private String Doctorphoto;

    private String DoctorDesignation;

    private String DoctorQualification;

    private String Doctorschedule;

}
