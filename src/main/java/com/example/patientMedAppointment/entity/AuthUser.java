package com.example.patientMedAppointment.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("users")
public class AuthUser {

    @Id
    private String id;

    @Indexed
    @NotBlank(message = "Name is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private boolean active;

    public boolean isActive() {  //  Explicit getter for boolean field
        return active;
    }

    public String getUsername() {  //  Explicit getter for username
        return username;
    }

    public String getPassword() {  //  Explicit getter for password
        return password;
    }
}
