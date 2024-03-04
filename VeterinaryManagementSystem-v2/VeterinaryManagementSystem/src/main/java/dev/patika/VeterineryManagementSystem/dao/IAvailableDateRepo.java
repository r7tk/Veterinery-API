package dev.patika.VeterineryManagementSystem.dao;

import dev.patika.VeterineryManagementSystem.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvailableDateRepo extends JpaRepository<AvailableDate,Long> {

}
