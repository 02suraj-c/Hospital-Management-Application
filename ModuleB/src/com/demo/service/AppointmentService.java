
package com.demo.service;

import com.demo.model.Patient;
import com.demo.model.Doctor;
import com.demo.model.Appointment;
import com.demo.enums.AppointmentStatus;
import com.demo.repository.AppointmentRepository;
import java.time.LocalDate;
import java.util.List;

public class AppointmentService {

    private final AppointmentRepository repository =
            new AppointmentRepository();

    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentService(PatientService patientService,
                              DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    public void scheduleAppointment(int appointmentId,
                                    int patientId,
                                    int doctorId,
                                    LocalDate date) {

        if (repository.findAppointmentById(appointmentId) != null) {
            System.out.println("Appointment ID already exists!");
            return;
        }

        Patient patient = patientService.findPatientById(patientId);
        Doctor doctor = doctorService.findDoctorById(doctorId);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            System.out.println("Cannot schedule an appointment in the past!");
            return;
        }

        Appointment appointment =
                new Appointment(appointmentId, patient, doctor, date);

        repository.addAppointment(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    public List<Appointment> getAllAppointments() {
        return repository.getAllAppointments();
    }

    public void cancelAppointment(int appointmentId) {
        Appointment appointment =
                repository.findAppointmentById(appointmentId);

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            System.out.println("Appointment is already cancelled!");
            return;
        }

        appointment.cancelAppointment();
        System.out.println("Appointment cancelled successfully!");
    }
}
