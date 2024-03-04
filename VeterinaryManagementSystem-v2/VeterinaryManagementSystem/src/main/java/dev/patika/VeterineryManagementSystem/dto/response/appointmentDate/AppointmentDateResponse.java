package dev.patika.VeterineryManagementSystem.dto.response.appointmentDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDateResponse {

    @NotNull(message = "Cannot be empty")
    private Long id;
    private LocalDateTime appointmenDate;

}
