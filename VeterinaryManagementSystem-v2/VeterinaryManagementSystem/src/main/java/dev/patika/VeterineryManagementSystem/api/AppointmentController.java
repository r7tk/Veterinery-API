package dev.patika.VeterineryManagementSystem.api;

import dev.patika.VeterineryManagementSystem.business.abstracts.IAppointmentService;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByAnimalDTO;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByDoctorDTO;
import dev.patika.VeterineryManagementSystem.entities.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("v1/appointments")
@AllArgsConstructor
public class AppointmentController {
    private final IAppointmentService appointmentService;

    // Değerlendirme formu 14
    

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment save(@RequestBody Appointment appointment) { //entitiy'i gönderdik.
        return this.appointmentService.save(appointment);
    }



    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update (@RequestBody Appointment appointment) {
        return this.appointmentService.update(appointment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.appointmentService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getById(@PathVariable("id") Long id) {
        return this.appointmentService.getById(id);
    }

    // Değerlendirme formu 24
    // kontrol edildi.
    @GetMapping("/filterbyDoctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> filterbyDoctor(
            @RequestParam(name = "doctor_id") Long doctorId ,
            @RequestParam(name = "startDate") LocalDateTime startDate ,
            @RequestParam(name = "endDate") LocalDateTime endDate) {

        return this.appointmentService.filterbyDoctor(doctorId,startDate,endDate);
    }

    // Değerlendirme formu 23
    @GetMapping("/filterbyAnimal")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> filterbyAnimal(
            @RequestParam(name = "animal_id") Long animalId ,
            @RequestParam(name = "startDate") LocalDateTime startDate ,
            @RequestParam(name = "endDate") LocalDateTime endDate) {
        return this.appointmentService.filterbyAnimal(animalId,startDate,endDate);
    }

}
