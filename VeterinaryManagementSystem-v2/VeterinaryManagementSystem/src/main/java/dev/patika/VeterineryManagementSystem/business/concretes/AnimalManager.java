package dev.patika.VeterineryManagementSystem.business.concretes;


import dev.patika.VeterineryManagementSystem.dao.IAnimalRepo;
import dev.patika.VeterineryManagementSystem.entities.Animal;
import dev.patika.VeterineryManagementSystem.entities.Customer;
import dev.patika.VeterineryManagementSystem.business.abstracts.IAnimalService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {
    private final IAnimalRepo animalRepo;
    private final EntityManager entityManager;

    public AnimalManager(IAnimalRepo animalRepo, EntityManager entityManager) {
        this.animalRepo = animalRepo;
        this.entityManager = entityManager;
    }

    @Override

    public Animal save(Animal animal) { // KONTROL EDİLDİ ÇALIŞIYOR
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal update(Animal animal) { // HENÜZ DENEMEDİM
        Animal checkAnimal = getById(animal.getId());
        if (checkAnimal != null) {
            return this.animalRepo.save(animal);
        } else {
            throw new RuntimeException(animal.getId() + " id’li kayıt sistemde bulunamadı.");
        }
    }

    @Override
    public Animal getById(Long id) { // KONTROL EDİLDİ ÇALIŞIYOR
        Animal animal = this.animalRepo.findById(id).orElse(null);
        if (animal == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return animal;
        }
    }

    @Override
    public Animal delete(Long id) { // HENÜZ DENEMEDİM
        Animal animal = this.animalRepo.findById(id).orElse(null);
        if (getById(id) == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            this.animalRepo.deleteById(id);
            return animal;
        }
    }


    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }


    // Animal Class'ında name database karşılığı animal_name denk geliyor.
    @Override // KONTROL EDİLDİ ÇALIŞIYOR
    public List<Animal> getFilteredAnimalByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT a FROM Animal a WHERE a.name ILIKE :animal_name";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("animal_name", "%" + name + "%");

        return query.getResultList();
    }

    @Override // KONTROL EDİLDİ ÇALIŞIYOR
    public List<Animal> getAnimalsByCustomerId(Long customerId) {

        String jpql = "SELECT a FROM Animal a WHERE a.customer.id = :customer_id";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customer_id", customerId);

        return query.getResultList();
    }


}
