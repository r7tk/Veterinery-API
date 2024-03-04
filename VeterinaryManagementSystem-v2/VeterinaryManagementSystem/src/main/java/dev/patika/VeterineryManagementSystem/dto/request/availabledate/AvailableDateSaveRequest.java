package dev.patika.VeterineryManagementSystem.dto.request.availabledate;

import dev.patika.VeterineryManagementSystem.entities.Doctor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    @NotNull(message = "Müsait Zaman Kısmı Boş Bırakılamaz ve Null Olamaz.")
    //@NotEmpty
    private LocalDate availableDate;
    private Doctor doctor;
}
