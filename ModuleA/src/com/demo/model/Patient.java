
package com.demo.model;

import com.demo.enums.TreatmentType;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private TreatmentType treatmentType;

    public Patient(int patientId, String name, int age,
                   TreatmentType treatmentType) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.treatmentType = treatmentType;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId
                + ", Name: " + name
                + ", Age: " + age
                + ", Treatment: " + treatmentType;
    }
}
