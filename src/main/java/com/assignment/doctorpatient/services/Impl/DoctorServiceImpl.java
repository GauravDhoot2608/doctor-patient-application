package com.assignment.doctorpatient.services.Impl;

import com.assignment.doctorpatient.dtos.DoctorRequest;
import com.assignment.doctorpatient.entities.Doctor;
import com.assignment.doctorpatient.enums.Speciality;
import com.assignment.doctorpatient.enums.Symptom;
import com.assignment.doctorpatient.exceptions.ResourceNotFoundException;
import com.assignment.doctorpatient.repositories.DoctorRepository;
import com.assignment.doctorpatient.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorRequest doctorRequest){

        String speciality = doctorRequest.getSpeciality();
        Speciality doctorSpeciality;
        try{
            doctorSpeciality = Speciality.valueOf(speciality.toUpperCase());
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("!! Invalid Doctor Speciality !! \n" +
                    "doctor speciality: " + Arrays.stream(Speciality.values()).toList());
        }

        Doctor doctor = Doctor.builder()
                .name(doctorRequest.getName().toUpperCase())
                .city(doctorRequest.getCity().trim().toUpperCase())
                .email(doctorRequest.getEmail())
                .phoneNumber(doctorRequest.getPhoneNumber())
                .speciality(doctorSpeciality)
                .build();

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId){
        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
        }else{
            throw new ResourceNotFoundException("!! Invalid doctor id: " + doctorId + " !!");
        }
    }
}
