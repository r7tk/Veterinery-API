package dev.patika.VeterineryManagementSystem.dao;

import dev.patika.VeterineryManagementSystem.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine,Long> {
}
