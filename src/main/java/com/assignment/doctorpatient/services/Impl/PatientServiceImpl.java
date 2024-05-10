package com.assignment.doctorpatient.services.Impl;

import com.assignment.doctorpatient.dtos.PatientRequest;
import com.assignment.doctorpatient.entities.Doctor;
import com.assignment.doctorpatient.entities.Patient;
import com.assignment.doctorpatient.enums.Symptom;
import com.assignment.doctorpatient.exceptions.ResourceNotFoundException;
import com.assignment.doctorpatient.repositories.DoctorRepository;
import com.assignment.doctorpatient.repositories.PatientRepository;
import com.assignment.doctorpatient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public Patient addPatient(PatientRequest patientRequest){

        String symptom = patientRequest.getSymptom();
        Symptom patientSymptom;
        try{
            patientSymptom = Symptom.valueOf(symptom.trim().replaceAll(" " , "_").toUpperCase());
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("!! Invalid Patient Symptom !! \n" + "patient symptom: " + Arrays.stream(Symptom.values()).toList());
        }

        Patient patient = Patient.builder()
                .name(patientRequest.getName().toUpperCase())
                .city(patientRequest.getCity().trim().toUpperCase())
                .email(patientRequest.getEmail())
                .phoneNumber(patientRequest.getPhoneNumber())
                .symptom(patientSymptom)
                .build();

        return patientRepository.save(patient);
    }

    public void deletePatient(Long patientId){
        if(patientRepository.existsById(patientId)){
            patientRepository.deleteById(patientId);
        }else {
           throw new ResourceNotFoundException("!! Invalid patient id: " + patientId + " !!");
        }
    }

    public List<Doctor> suggestDoctor(Long patientId){
        List<Doctor> doctors = new ArrayList<>();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("!! Invalid patient id: " + patientId + " !!"));

        String patientCity = patient.getCity();
        Symptom patientSymptom = patient.getSymptom();



        if(!patientCity.equals("DELHI") && !patientCity.equals("NOIDA") && !patientCity.equals("FARIDABAD")){
            throw new ResourceNotFoundException("We are still waiting to expand to your location");
        }

        List<Doctor> doctorListByCity = doctorRepository.findByCity(patientCity);
        for(Doctor doctor : doctorListByCity){
            if(doctor.getSpeciality().equals(patientSymptom.getSpeciality())){
                doctors.add(doctor);
            }
        }
        if(doctors.isEmpty()){
            throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom");
        }
        return doctors;
    }
}
