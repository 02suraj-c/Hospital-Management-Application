
package com.demo.app;

import com.demo.model.Patient;
import com.demo.model.Doctor;
import com.demo.model.Appointment;

import com.demo.enums.TreatmentType;
import com.demo.enums.Specialization;

import com.demo.service.PatientService;
import com.demo.service.DoctorService;
import com.demo.service.AppointmentService;

import com.demo.util.InputUtil;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();

        AppointmentService appointmentService =
                new AppointmentService(patientService, doctorService);

        boolean running = true;

        while (running) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Register Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View All Appointments");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    registerPatient(patientService);
                    break;

                case 2:
                    viewPatients(patientService);
                    break;

                case 3:
                    registerDoctor(doctorService);
                    break;

                case 4:
                    viewDoctors(doctorService);
                    break;

                case 5:
                    scheduleAppointment(appointmentService);
                    break;

                case 6:
                    viewAppointments(appointmentService);
                    break;

                case 7:
                    cancelAppointment(appointmentService);
                    break;

                case 8:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        InputUtil.closeScanner();
    }

    private static void registerPatient(PatientService service) {

        int id = InputUtil.readInt("Enter patient ID: ");
        String name = InputUtil.readString("Enter patient name: ");
        int age = InputUtil.readInt("Enter patient age: ");

        System.out.println("Treatment types:");
        for (TreatmentType type : TreatmentType.values()) {
            System.out.println("- " + type);
        }

        TreatmentType treatment;
        while (true) {
            String value = InputUtil.readString(
                    "Enter treatment type: ").toUpperCase();

            try {
                treatment = TreatmentType.valueOf(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid treatment type. Try again.");
            }
        }

        Patient patient = new Patient(id, name, age, treatment);
        service.registerPatient(patient);
    }

    private static void viewPatients(PatientService service) {

        System.out.println("\n--- Patient Records ---");

        if (service.getAllPatients().isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }

        for (Patient patient : service.getAllPatients()) {
            System.out.println(patient);
        }
    }

    private static void registerDoctor(DoctorService service) {

        int id = InputUtil.readInt("Enter doctor ID: ");
        String name = InputUtil.readString("Enter doctor name: ");

        System.out.println("Specializations:");
        for (Specialization specialization : Specialization.values()) {
            System.out.println("- " + specialization);
        }

        Specialization specialization;
        while (true) {
            String value = InputUtil.readString(
                    "Enter specialization: ").toUpperCase();

            try {
                specialization = Specialization.valueOf(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid specialization. Try again.");
            }
        }

        Doctor doctor = new Doctor(id, name, specialization);
        service.registerDoctor(doctor);
    }

    private static void viewDoctors(DoctorService service) {

        System.out.println("\n--- Doctor Records ---");

        if (service.getAllDoctors().isEmpty()) {
            System.out.println("No doctors registered.");
            return;
        }

        for (Doctor doctor : service.getAllDoctors()) {
            System.out.println(doctor);
        }
    }

    private static void scheduleAppointment(
            AppointmentService service) {

        int appointmentId =
                InputUtil.readInt("Enter appointment ID: ");

        int patientId =
                InputUtil.readInt("Enter patient ID: ");

        int doctorId =
                InputUtil.readInt("Enter doctor ID: ");

        LocalDate date;

        while (true) {
            String value = InputUtil.readString(
                    "Enter appointment date (YYYY-MM-DD): ");

            try {
                date = LocalDate.parse(value);
                break;
            } catch (DateTimeParseException e) {
                System.out.println(
                        "Invalid date. Example: 2026-12-18");
            }
        }

        service.scheduleAppointment(
                appointmentId, patientId, doctorId, date);
    }

    private static void viewAppointments(
            AppointmentService service) {

        System.out.println("\n--- Appointment Records ---");

        if (service.getAllAppointments().isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : service.getAllAppointments()) {
            System.out.println(appointment);
            System.out.println("--------------------------");
        }
    }

    private static void cancelAppointment(
            AppointmentService service) {

        int id = InputUtil.readInt("Enter appointment ID to cancel: ");
        service.cancelAppointment(id);
    }
}
