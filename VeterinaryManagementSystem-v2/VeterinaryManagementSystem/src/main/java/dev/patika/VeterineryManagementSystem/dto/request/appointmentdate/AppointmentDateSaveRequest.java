package dev.patika.VeterineryManagementSystem.dto.request.appointmentdate;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDateSaveRequest {
    @NotNull(message = "Randevu Zamanı Kısmı Boş Bırakılamaz ve Null Olamaz.")
    //@NotEmpty
    private LocalDateTime appointmenDate;
}
