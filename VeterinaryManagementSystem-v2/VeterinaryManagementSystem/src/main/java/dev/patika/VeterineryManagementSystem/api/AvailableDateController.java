package dev.patika.VeterineryManagementSystem.api;

import dev.patika.VeterineryManagementSystem.business.abstracts.IAvailableDateService;
import dev.patika.VeterineryManagementSystem.entities.AvailableDate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping ("v1/availabledates") public class AvailableDateController {
    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    // Değerlendirme formu 13
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDate save(@RequestBody AvailableDate availableDate)  {
        return this.availableDateService.save(availableDate);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate update (@RequestBody AvailableDate availableDate) {
        return this.availableDateService.update(availableDate);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.availableDateService.delete(id);
    }


    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate getById(@PathVariable("id") Long id) {
        return this.availableDateService.getById(id);
    }
}

