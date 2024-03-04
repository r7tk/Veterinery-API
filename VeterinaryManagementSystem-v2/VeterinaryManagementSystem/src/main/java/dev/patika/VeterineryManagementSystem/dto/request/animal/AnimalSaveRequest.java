package dev.patika.VeterineryManagementSystem.dto.request.animal;

import dev.patika.VeterineryManagementSystem.entities.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {
    @NotNull(message = "Animal Kısmı Boş Bırakılamaz ve Null Olamaz.")
    //@NotEmpty
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private LocalDate dateOfBirth;
    private Customer customer;
}
