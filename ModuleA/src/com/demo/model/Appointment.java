
package com.demo.model;

import java.time.LocalDate;
import com.demo.enums.AppointmentStatus;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;
    private AppointmentStatus status;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, LocalDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void cancelAppointment() {
        this.status = AppointmentStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId
                + "\nPatient: " + patient.getName()
                + "\nDoctor: " + doctor.getName()
                + "\nDate: " + appointmentDate
                + "\nStatus: " + status;
    }
}
