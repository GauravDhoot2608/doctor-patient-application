package com.assignment.doctorpatient.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PatientRequest {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3,}$" , message = "Name should have at least 3 characters. " +
            "It allows only alphabetic characters with no spaces between them.")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "City should have at most 20 characters. " +
            "It allows only alphabetic characters with no spaces between them.")
    private String city;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "\\d{10,}", message = "Phone number should have at least 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "symptom is required")
    private String symptom;
}
