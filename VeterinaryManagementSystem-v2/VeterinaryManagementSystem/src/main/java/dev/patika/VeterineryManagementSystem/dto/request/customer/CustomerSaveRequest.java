package dev.patika.VeterineryManagementSystem.dto.request.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {
    @NotNull(message = "Müşteri Kısmı Boş Bırakılamaz ve Null Olamaz.")
   // @NotEmpty

    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
