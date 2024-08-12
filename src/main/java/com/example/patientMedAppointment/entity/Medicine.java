package com.example.patientMedAppointment.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Medicine")
public class Medicine {

    @Id
    private String id;
    @NotBlank(message = "Name is mandatory")
    private String patientname;
    @NotBlank(message = "Name is mandatory")
    private String medicinename;
    private String dosage;
}
