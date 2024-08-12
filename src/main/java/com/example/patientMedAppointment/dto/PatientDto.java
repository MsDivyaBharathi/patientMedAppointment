package com.example.patientMedAppointment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String id;
    @NotEmpty(message = "Name can't be null/empty")
    private String patientname;
    @NotEmpty(message = "Age can't be null/empty")
    private String age;
    @NotEmpty(message = "EMail can't be null/empty")
    private String email;
    @NotEmpty(message = "Phone NUmber can't be null/empty")
    private String phoneNumber;
    @NotEmpty(message = "medical History can't be null/empty")
    private String medicalHistory;

}
