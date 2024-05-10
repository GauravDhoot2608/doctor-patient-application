package com.assignment.doctorpatient.entities;

import com.assignment.doctorpatient.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @Email
    private String email;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Symptom symptom;
}
