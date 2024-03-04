package dev.patika.VeterineryManagementSystem.business.abstracts;

import dev.patika.VeterineryManagementSystem.entities.Animal;
import dev.patika.VeterineryManagementSystem.entities.Vaccine;
import dev.patika.VeterineryManagementSystem.dto.AnimalVaccineDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    Vaccine save (Vaccine vaccine);
    Vaccine update (Vaccine vaccine);
    Vaccine getById(Long id);
    void delete(Long id);
    List<Vaccine> findAll();
    List<Vaccine> getVaccinesByAnimalId(Long animalId); //animal id'ye göre aşı listesi döner.
    List<Animal> getAnimalsByComingVaccines(LocalDate enterDate, LocalDate exitDate);

}
