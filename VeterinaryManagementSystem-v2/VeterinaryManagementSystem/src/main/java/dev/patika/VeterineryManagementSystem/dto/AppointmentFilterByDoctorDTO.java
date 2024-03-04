package dev.patika.VeterineryManagementSystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentFilterByDoctorDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long doctorId;

}
