package com.assignment.doctorpatient.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DoctorRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3,}$" , message = "Name should have at least 3 characters. " +
            "It allows only alphabetic characters with no spaces between them.")
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?i)(Delhi|Noida|Faridabad)$", message = "City must be Delhi, Noida, or Faridabad. " +
            "It allows only alphabetic characters with no spaces between them.")
    private String city;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "\\d{10,}", message = "Phone number should have at least 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "speciality is required")
    private String speciality;
}
