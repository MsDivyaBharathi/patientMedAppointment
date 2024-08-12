package com.example.patientMedAppointment.entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Users")
public class AuthUser {

    @Id
    private String id;

    @Indexed
    @NotBlank(message = "Name is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotBlank
    private boolean active;

    //@DBRef
    //private Set<Role> roles;

}
