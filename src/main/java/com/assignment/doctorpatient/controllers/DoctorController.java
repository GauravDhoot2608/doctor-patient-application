package com.assignment.doctorpatient.controllers;

import com.assignment.doctorpatient.dtos.DoctorRequest;
import com.assignment.doctorpatient.entities.Doctor;
import com.assignment.doctorpatient.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@Valid @RequestBody DoctorRequest doctorRequest){
        Doctor doctor = doctorService.addDoctor(doctorRequest);
        return new ResponseEntity(doctor , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity("Doctor with id: " + id + " successfully deleted" , HttpStatus.OK);
    }
}
