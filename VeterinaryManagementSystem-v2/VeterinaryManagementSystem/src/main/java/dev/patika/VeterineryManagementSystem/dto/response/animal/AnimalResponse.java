package dev.patika.VeterineryManagementSystem.dto.response.animal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {

    @NotNull(message = "Cannot be empty")
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private String dateOfBirth;
}
