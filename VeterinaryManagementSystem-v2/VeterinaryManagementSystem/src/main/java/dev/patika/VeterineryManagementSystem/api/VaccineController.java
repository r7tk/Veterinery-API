package dev.patika.VeterineryManagementSystem.api;

import dev.patika.VeterineryManagementSystem.business.abstracts.IVaccineService;
import dev.patika.VeterineryManagementSystem.dto.AnimalVaccineDTO;
import dev.patika.VeterineryManagementSystem.entities.Animal;
import dev.patika.VeterineryManagementSystem.entities.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping ("v1/vaccines")
public class VaccineController {
    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccine) {
        return this.vaccineService.save(vaccine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update (@RequestBody Vaccine vaccine) {
        return this.vaccineService.update(vaccine);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.vaccineService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getById(@PathVariable("id") Long id) {
        return this.vaccineService.getById(id);
    }

    // Değerlendirme formu 20
    // Kontrol Edildi.
    @GetMapping("/getVaccinesByAnimalId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> getVaccinesByAnimalId(@PathVariable("id") Long id) {
        return this.vaccineService.getVaccinesByAnimalId(id);
    }

    // Değerlendirme formu 21
    // Kontrol edildi.
    @GetMapping("/getAnimalsByComingVaccines")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimalsByComingVaccines(
            @RequestParam(name = "enterDate") LocalDate enterDate ,
            @RequestParam(name = "exitDate") LocalDate exitDate) {

        return this.vaccineService.getAnimalsByComingVaccines(enterDate,exitDate);
    }
}