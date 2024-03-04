package dev.patika.VeterineryManagementSystem.business.abstracts;

import dev.patika.VeterineryManagementSystem.entities.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor save (Doctor doctor);
    Doctor update (Doctor doctor);
    Doctor getById(Long id);
    void delete(Long id);
    List<Doctor> findAll();
}
