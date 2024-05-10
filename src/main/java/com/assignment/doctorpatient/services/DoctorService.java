package com.assignment.doctorpatient.services;

import com.assignment.doctorpatient.dtos.DoctorRequest;
import com.assignment.doctorpatient.entities.Doctor;

public interface DoctorService {

    public Doctor addDoctor(DoctorRequest doctorRequest);

    public void deleteDoctor(Long doctorId);
}
