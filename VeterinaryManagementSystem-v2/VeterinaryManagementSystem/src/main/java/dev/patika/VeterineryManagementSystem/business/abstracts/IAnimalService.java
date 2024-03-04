package dev.patika.VeterineryManagementSystem.business.abstracts;

import dev.patika.VeterineryManagementSystem.entities.Animal;

import java.util.List;

public interface IAnimalService {

    Animal save (Animal animal);
    Animal update (Animal animal);
    Animal getById(Long id);
    Animal delete(Long id);
    List<Animal> findAll();
    public List<Animal> getFilteredAnimalByName(String name);

    List<Animal> getAnimalsByCustomerId(Long customerId); //customer id'ye göre animal listesi döner.


}
