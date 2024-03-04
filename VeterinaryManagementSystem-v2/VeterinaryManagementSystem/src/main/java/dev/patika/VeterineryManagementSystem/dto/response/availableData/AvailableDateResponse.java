package dev.patika.VeterineryManagementSystem.dto.response.availableData;

import dev.patika.VeterineryManagementSystem.entities.Doctor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateResponse {

    @NotNull(message = "Cannot be empty")
    private Long id;
    private LocalDate availableDate;
    private Doctor doctor = new Doctor();
}
