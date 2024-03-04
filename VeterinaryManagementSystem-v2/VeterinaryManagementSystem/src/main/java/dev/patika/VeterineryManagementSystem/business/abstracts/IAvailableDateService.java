package dev.patika.VeterineryManagementSystem.business.abstracts;

import dev.patika.VeterineryManagementSystem.entities.AvailableDate;

import java.util.List;

public interface IAvailableDateService {

    AvailableDate save (AvailableDate availableDate);
    AvailableDate update (AvailableDate availableDate);
    AvailableDate getById(Long id);
    void delete(Long id);
    List<AvailableDate> findAll();
}
