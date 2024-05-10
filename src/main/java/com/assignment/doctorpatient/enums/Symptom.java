package com.assignment.doctorpatient.enums;

public enum Symptom {

    ARTHRITIS(Speciality.ORTHOPEDIC),
    BACK_PAIN(Speciality.ORTHOPEDIC),
    TISSUE_INJURIES(Speciality.ORTHOPEDIC),
    DYSMENORRHEA(Speciality.GYNECOLOGY),
    SKIN_INFECTION(Speciality.DERMATOLOGY),
    SKIN_BURN(Speciality.DERMATOLOGY),
    EAR_PAIN(Speciality.ENT);

    private final Speciality speciality;

    Symptom(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}
