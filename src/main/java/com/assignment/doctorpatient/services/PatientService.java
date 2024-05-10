package com.assignment.doctorpatient.services;

import com.assignment.doctorpatient.dtos.PatientRequest;
import com.assignment.doctorpatient.entities.Doctor;
import com.assignment.doctorpatient.entities.Patient;
import java.util.List;

public interface PatientService {

    public Patient addPatient(PatientRequest patientRequest);

    public void deletePatient(Long patientId);

    public List<Doctor> suggestDoctor(Long patientId);
}
