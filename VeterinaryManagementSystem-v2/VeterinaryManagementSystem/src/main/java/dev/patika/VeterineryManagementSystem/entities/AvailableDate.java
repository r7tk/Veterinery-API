package dev.patika.VeterineryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "available_dates")
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_id")
    private Long id;


    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    //Doktorun çalıştığı günler sisteme LocalDate olarak kaydedilecektir. Sadece tarih bilgisi olacaktır. Saat, dakika, saniye bilgisi olmayacaktır.
    private LocalDate availableDateDate;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "available_date_doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;
}
