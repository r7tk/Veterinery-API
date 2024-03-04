package dev.patika.VeterineryManagementSystem.business.concretes;

import dev.patika.VeterineryManagementSystem.dao.IAvailableDateRepo;
import dev.patika.VeterineryManagementSystem.entities.AvailableDate;
import dev.patika.VeterineryManagementSystem.business.abstracts.IAvailableDateService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final IAvailableDateRepo availableDateRepo;
    private final EntityManager entityManager;

    public AvailableDateManager(IAvailableDateRepo availableDateRepo, EntityManager entityManager) {
        this.availableDateRepo = availableDateRepo;
        this.entityManager = entityManager;
    }


    @Override
    public AvailableDate save(AvailableDate availableDate) {
        List<AvailableDate> availableDates = checkAvailableDatesByDoctor(availableDate);
        if (availableDates.size() == 0) {
            return this.availableDateRepo.save(availableDate);
        } else {
            throw new RuntimeException("Bu doktorun bugün için müsaitliği daha önce eklenmiştir.");
        }
    }


    @Override
    public AvailableDate update(AvailableDate availableDate) {
        getById(availableDate.getId());
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDate getById(Long id) {

        AvailableDate availableDate = this.availableDateRepo.findById(id).orElse(null);
        if (availableDate == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return availableDate;
        }
    }

    @Override
    public void delete(Long id) {
        AvailableDate checkAvailableDate = getById(id);
        if (checkAvailableDate != null) {
            this.availableDateRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        }
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }

    public List<AvailableDate> checkAvailableDatesByDoctor(AvailableDate availableDate) {
        String queryString = "SELECT a FROM AvailableDate a WHERE a.doctor.id = :doctor_id AND a.availableDateDate = :available_date";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", availableDate.getDoctor().getId());
        query.setParameter("available_date", availableDate.getAvailableDateDate());

        return query.getResultList();
    }
}
