package dev.patika.VeterineryManagementSystem.business.abstracts;
import dev.patika.VeterineryManagementSystem.entities.Appointment;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByAnimalDTO;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByDoctorDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {

    Appointment save (Appointment appointment);
    Appointment update (Appointment appointment);
    Appointment getById(Long id);
    void delete(Long id);
    List<Appointment> findAll();

    List<Appointment> filterbyDoctor(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
    public List<Appointment> filterbyAnimal(Long animalId,LocalDateTime startDate, LocalDateTime endDate);
}
