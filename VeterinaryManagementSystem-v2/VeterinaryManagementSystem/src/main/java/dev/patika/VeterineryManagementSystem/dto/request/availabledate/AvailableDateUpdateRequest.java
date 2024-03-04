package dev.patika.VeterineryManagementSystem.dto.request.availabledate;

import dev.patika.VeterineryManagementSystem.entities.Doctor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    @NotNull(message = "Müsait Zaman Kısmı Boş Bırakılamaz ve Null Olamaz.")
    //@NotEmpty
    private Long id;
    private LocalDate availableDate;
    private Doctor doctor = new Doctor();
}
