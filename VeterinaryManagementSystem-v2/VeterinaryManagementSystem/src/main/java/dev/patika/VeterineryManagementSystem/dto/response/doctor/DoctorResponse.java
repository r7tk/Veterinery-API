package dev.patika.VeterineryManagementSystem.dto.response.doctor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorResponse {

    @NotNull(message = "Cannot be empty")
    private Long id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
