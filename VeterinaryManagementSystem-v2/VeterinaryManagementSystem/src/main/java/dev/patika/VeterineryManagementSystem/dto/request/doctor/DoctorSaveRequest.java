package dev.patika.VeterineryManagementSystem.dto.request.doctor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {
    @NotNull(message = "Doktor Boş Bırakılamaz ve Null Olamaz.")
   // @NotEmpty
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
