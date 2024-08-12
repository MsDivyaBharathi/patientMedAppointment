package com.example.patientMedAppointment.entity;

import com.example.patientMedAppointment.dto.PatientDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("DoctorDetails")
public class Doctor {

    private String id;

    @NotBlank(message = "Name is mandatory")
    private String doctorname;

    private String Doctorphoto;

    @NotBlank(message = "Doctor Designation is mandatory")
    private String DoctorDesignation;

    @NotBlank(message = "Doctor Qualification is mandatory")
    private String DoctorQualification;

    private String Doctorschedule;

}
