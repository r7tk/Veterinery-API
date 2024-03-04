package dev.patika.VeterineryManagementSystem.dao;

import dev.patika.VeterineryManagementSystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {
}
