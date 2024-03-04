package dev.patika.VeterineryManagementSystem.dao;

import dev.patika.VeterineryManagementSystem.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepo extends JpaRepository<Animal,Long> {

}
