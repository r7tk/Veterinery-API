package dev.patika.VeterineryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalVaccineDTO {
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
}
