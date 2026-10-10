
package com.demo.model;

import com.demo.enums.Specialization;

public class Doctor {

    private int doctorId;
    private String name;
    private Specialization specialization;

    public Doctor(int doctorId, String name,
                  Specialization specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId
                + ", Name: " + name
                + ", Specialization: " + specialization;
    }
}
