
package com.demo.service;

import com.demo.model.Doctor;
import com.demo.repository.DoctorRepository;
import java.util.List;

public class DoctorService {

    private final DoctorRepository repository =
            new DoctorRepository();

    public void registerDoctor(Doctor doctor) {
        if (repository.findDoctorById(doctor.getDoctorId()) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        repository.addDoctor(doctor);
        System.out.println("Doctor registered successfully!");
    }

    public List<Doctor> getAllDoctors() {
        return repository.getAllDoctors();
    }

    public Doctor findDoctorById(int doctorId) {
        return repository.findDoctorById(doctorId);
    }
}
