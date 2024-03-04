package dev.patika.VeterineryManagementSystem.api;

import dev.patika.VeterineryManagementSystem.business.abstracts.IAnimalService;
import dev.patika.VeterineryManagementSystem.business.abstracts.ICustomerService;
import dev.patika.VeterineryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.VeterineryManagementSystem.core.result.ResultData;
import dev.patika.VeterineryManagementSystem.core.utilies.ResultHelper;
import dev.patika.VeterineryManagementSystem.dto.request.animal.AnimalSaveRequest;
import dev.patika.VeterineryManagementSystem.dto.request.animal.AnimalUpdateRequest;
import dev.patika.VeterineryManagementSystem.entities.Customer;
import dev.patika.VeterineryManagementSystem.dto.response.animal.AnimalResponse;
import dev.patika.VeterineryManagementSystem.entities.Animal;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
@AllArgsConstructor
public class AnimalController {
    private final IAnimalService animalService;
    private final IModelMapperService modelmapper;
    private final ICustomerService customerService;

    // Değerlendirme formu 11
    @PostMapping(("/save"))
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        Animal animal = this.modelmapper.forRequest().map(animalSaveRequest, Animal.class);

        Customer customer = this.customerService.getById(animalSaveRequest.getCustomer().getId());
        animal.setCustomer(customer);

        this.animalService.save(animal);
        return ResultHelper.created(this.modelmapper.forRequest().map(animal, AnimalResponse.class));
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        Animal animal = this.modelmapper.forRequest().map(animalUpdateRequest, Animal.class);

        Customer customer = this.customerService.getById(animalUpdateRequest.getCustomer().getId());
        animal.setCustomer(customer);

        this.animalService.update(animal);
        return ResultHelper.success(this.modelmapper.forRequest().map(animal, AnimalResponse.class));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> delete(@PathVariable("id") Long id) {
        Animal animal = this.animalService.delete(id);
        return ResultHelper.success(this.modelmapper.forRequest().map(animal, AnimalResponse.class));
    }


    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id") Long id) {
        return this.animalService.getById(id);
    }

    // Değerlendirme formu 16
    @GetMapping("/getFilteredAnimalByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getFilteredAnimalByName(@PathVariable("name") String name) {
        return this.animalService.getFilteredAnimalByName(name);
    }

    // Değerlendirme formu 18
    @GetMapping("/getAnimalsByCustomerId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimalsByCustomerId(@PathVariable("id") Long customerId) {
        return this.animalService.getAnimalsByCustomerId(customerId);
    }


}

