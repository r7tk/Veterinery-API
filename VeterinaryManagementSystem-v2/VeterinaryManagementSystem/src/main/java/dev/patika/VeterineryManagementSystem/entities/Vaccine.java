package dev.patika.VeterineryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_code")
    private String code;

    @Column (name = "vaccine_protection_start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate protectionStartDate;

    @Column (name = "vaccine_protection_finish_date")
    @Temporal(TemporalType.DATE)
    private LocalDate protectionFinishDate;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
