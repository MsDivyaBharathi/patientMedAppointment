package com.example.patientMedAppointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {

    private String id;
    private String patientname;
    private String medicinename;
    private String dosage;

}
