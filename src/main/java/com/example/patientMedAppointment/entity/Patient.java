package com.example.patientMedAppointment.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Patient Registration")
public class Patient {

    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String patientname;

    @NotBlank(message = "Age is mandatory")
    private String age;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "phone Number is mandatory")
    private String phoneNumber;

    private String medicalHistory;
    
}
