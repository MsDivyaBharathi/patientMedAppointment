package com.example.patientMedAppointment.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Appointment {

    @Id
    private String id;

    private String starttime;

    private String endtime;

    //@JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private String appointmentdate;

    @NotBlank(message = "Doctor Name is mandatory")
    private String doctorname;

    @NotBlank(message = "Patient Name is mandatory")
    private String patientName;

    @NotBlank(message = "Patient Ph No is mandatory")
    private String patientPhoneNumber;

    //private Patient patient;
}
