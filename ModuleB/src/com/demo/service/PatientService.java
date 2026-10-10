
package com.demo.service;

import com.demo.model.Patient;
import com.demo.repository.PatientRepository;
import java.util.List;

public class PatientService {

    private final PatientRepository repository =
            new PatientRepository();

    public void registerPatient(Patient patient) {
        if (repository.findPatientById(patient.getPatientId()) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }

        repository.addPatient(patient);
        System.out.println("Patient registered successfully!");
    }

    public List<Patient> getAllPatients() {
        return repository.getAllPatients();
    }

    public Patient findPatientById(int patientId) {
        return repository.findPatientById(patientId);
    }
}
