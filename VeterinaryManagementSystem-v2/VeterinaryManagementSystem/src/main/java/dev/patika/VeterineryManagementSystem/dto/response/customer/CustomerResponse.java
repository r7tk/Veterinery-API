package dev.patika.VeterineryManagementSystem.dto.response.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerResponse {

    @NotNull(message = "Cannot be empty")
    private Long id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
