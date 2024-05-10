package com.assignment.doctorpatient.controllers;

import com.assignment.doctorpatient.dtos.PatientRequest;
import com.assignment.doctorpatient.entities.Doctor;
import com.assignment.doctorpatient.entities.Patient;
import com.assignment.doctorpatient.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@Valid @RequestBody PatientRequest patientRequest){
        Patient patient = patientService.addPatient(patientRequest);
        return new ResponseEntity(patient , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity("Patient with id: " + id + " successfully deleted" , HttpStatus.OK);
    }

    @GetMapping("/suggestedDoctors")
    public ResponseEntity suggestDoctors(@RequestParam("patientId") Long patientId){
        List<Doctor> doctors = patientService.suggestDoctor(patientId);
        return new ResponseEntity(doctors , HttpStatus.OK);
    }
}
